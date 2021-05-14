package com.cjenm.mwave.apis;

import org.jasypt.registry.AlgorithmRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MwaveApisApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("allDigestAlgorithms : "+ AlgorithmRegistry.getAllDigestAlgorithms());
        System.out.println("allPBEAlgorithms : "+ AlgorithmRegistry.getAllPBEAlgorithms());
        //AES512
        //allDigestAlgorithms : [MD2, MD5, SHA, SHA-224, SHA-256, SHA-384, SHA-512, SHA-512/224, SHA-512/256, SHA3-224, SHA3-256, SHA3-384, SHA3-512]
        //allPBEAlgorithms : [PBEWITHHMACSHA1ANDAES_128, PBEWITHHMACSHA1ANDAES_256, PBEWITHHMACSHA224ANDAES_128, PBEWITHHMACSHA224ANDAES_256, PBEWITHHMACSHA256ANDAES_128, PBEWITHHMACSHA256ANDAES_256, PBEWITHHMACSHA384ANDAES_128, PBEWITHHMACSHA384ANDAES_256, PBEWITHHMACSHA512ANDAES_128, PBEWITHHMACSHA512ANDAES_256, PBEWITHMD5ANDDES, PBEWITHMD5ANDTRIPLEDES, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1ANDRC2_128, PBEWITHSHA1ANDRC2_40, PBEWITHSHA1ANDRC4_128, PBEWITHSHA1ANDRC4_40]
    }

}
