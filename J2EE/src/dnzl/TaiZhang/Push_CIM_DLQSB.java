package dnzl.TaiZhang;

import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_CIM_SuperClass;
import dnzl.DataFactory.XmlFactory;

/**********************************************
 * 断路器设备
 *
 *********************************************/
public class Push_CIM_DLQSB extends Push_CIM_SuperClass{

	@Override
	public void initData() {
		List<String> list = null;
		try {
			list = xmlContents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list == null || list.size() == 0){
			this.IsLog(false);
			this.IsNeed(false);
		}else{
			this.setXmlContents(list);
		}
	}
	
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_DLQSB();
	}
	public static void main(String[] args){
		Push_CIM_DLQSB obj = new Push_CIM_DLQSB();
		Thread thre = new Thread(obj);
		thre.start();
	}
}
