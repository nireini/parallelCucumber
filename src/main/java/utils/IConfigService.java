package utils;


public interface IConfigService {

	public void load(String env, String fileName) throws Exception;

	public String getProperty(String propName);

	public String getEnv();

	public String getSut();

}
