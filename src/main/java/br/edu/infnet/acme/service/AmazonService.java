package br.edu.infnet.acme.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmazonService {

    private AmazonS3 amazonS3;

    @Value("${amazonProperties.accessKey}")
    private String accessKey;

    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    private void initializeAmazon() {

        // AWS Credentials
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);

        // Credentials Provider
        var credentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);

        // AmazonS3ClientBuilder
        this.amazonS3 = AmazonS3ClientBuilder.standard().withRegion(Regions.SA_EAST_1).withCredentials(credentialsProvider).build();

    }

    public List<Bucket> listBuckets() {

        return amazonS3.listBuckets();
    }

}
