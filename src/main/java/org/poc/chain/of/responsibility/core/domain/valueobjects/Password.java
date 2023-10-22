package org.poc.chain.of.responsibility.core.domain.valueobjects;

import lombok.Builder;
import lombok.Data;

import javax.crypto.SecretKey;

@Data
@Builder
public class Password {
    private byte[] key;
    private SecretKey secretKey;
}
