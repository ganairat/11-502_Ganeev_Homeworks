package Utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash {
    public String getMd5Apache(String password){
        return DigestUtils.md5Hex(password);
    }
}
