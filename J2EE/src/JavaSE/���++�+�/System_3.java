package JavaSE.常用类库;

/**
 * 
 * @author 禅师
 * @resume
 * 		获取指定信息
 */
public class System_3 {

	public static void main(String[] args) {

		System.out.println("系统名称:" +System.getProperty("os.name") + "\n系统版本:"+System.getProperty("os.version"));
		System.out.println("当前用户:" +System.getProperty("user.name"));
		System.out.println("用户目录:" +System.getProperty("user.home"));
		System.out.println("当前目录:" +System.getProperty("user.dir"));
		
	}

}
