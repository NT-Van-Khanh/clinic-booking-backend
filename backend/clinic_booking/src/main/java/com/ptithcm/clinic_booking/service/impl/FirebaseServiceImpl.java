package com.ptithcm.clinic_booking.service.impl;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.StorageException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.StorageClient;
import com.ptithcm.clinic_booking.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseServiceImpl implements FirebaseService {

    @Value("${firebase.storage.bucket-name}")
    private String firebaseStorageBucketName;

    @Value("${firebase.storage.image-link}")
    private String firebaseStorageImageLink;

    private final StorageClient storageClient;

    @Autowired
    public FirebaseServiceImpl(FirebaseApp firebaseApp) {
        try {
            this.storageClient = StorageClient.getInstance(firebaseApp);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Firebase StorageClient: " + e.getMessage(), e);
        }
    }

    @Override
    public InputStream getObject(String fileName) throws IOException {
        try {
            Bucket bucket = this.storageClient.bucket();
            Blob blob = bucket.get(fileName);
            if (blob != null) {
                return new ByteArrayInputStream(blob.getContent());
            } else {
                throw new FileNotFoundException("File " + fileName + " not found in bucket " + firebaseStorageBucketName);
            }
        } catch (StorageException e) {
            throw new IOException("Error getting file " + fileName + ": " + e.getMessage(), e);
        }
    }

    @Override
    public String getObjectUrl(String fileName) throws IOException {
        try {
            Blob blob = storageClient.bucket().get(fileName);
            if (blob != null && blob.exists()) {
                return String.format(firebaseStorageImageLink, firebaseStorageBucketName, fileName);
            } else {
                throw new FileNotFoundException("File " + fileName + " not found in bucket " + firebaseStorageBucketName);
            }
        } catch (StorageException e) {
            throw new IOException("Error getting URL for file " + fileName + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void uploadObject(String fileName, InputStream inputStream, String contentType) throws IOException {
        try {
            Bucket bucket = storageClient.bucket();
            Blob blob = bucket.create(fileName, inputStream, contentType);
            if (blob == null) {
                throw new IOException("Failed to upload file " + fileName + " to bucket " + firebaseStorageBucketName);
            }
        } catch (StorageException e) {
            throw new IOException("Error uploading file " + fileName + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteObject(String fileName) throws IOException {
        try {
            Blob blob = storageClient.bucket().get(fileName);
            if (blob != null) {
                boolean deleted = blob.delete();
                if (!deleted) {
                    throw new IOException("Failed to delete file " + fileName + " from bucket " + firebaseStorageBucketName);
                }
            } else {
                throw new FileNotFoundException("File " + fileName + " not found in bucket " + firebaseStorageBucketName);
            }
        } catch (StorageException e) {
            throw new IOException("Error deleting file " + fileName + ": " + e.getMessage(), e);
        }
    }
}
