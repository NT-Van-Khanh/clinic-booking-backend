package com.ptithcm.clinic_booking.service;

import java.io.IOException;
import java.io.InputStream;

public interface FirebaseService {
    InputStream getObject(String fileName) throws IOException;
    String getObjectUrl( String fileName) throws IOException;
    void uploadObject( String fileName, InputStream inputStream,String contentType) throws IOException;
    void deleteObject( String fileName) throws IOException;
}
