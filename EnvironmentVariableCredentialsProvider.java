

public class EnvironmentVariableCredentialsProvider implements JCSCredentialsProvider {
    @Override
    public JCSCredentials getCredentials(){
        String accessKey = System.getenv("ACCESS_KEY");
        String secretKey = System.getenv("SECRET_KEY");
        
        accessKey = accessKey.trim();
        secretKey = secretKey.trim();
        
        if (Utils.isNullOrEmpty(accessKey) || Utils.isNullOrEmpty(secretKey)) {

            throw new RuntimeException(
                    "Unable to load JCS credentials from environment variables " +
                    "(" + accessKey + ") and (" + secretKey + ")");
        }

        
        return new BasicJCSCredentials(accessKey, secretKey);
    }

    @Override
    public void refresh() {}

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}