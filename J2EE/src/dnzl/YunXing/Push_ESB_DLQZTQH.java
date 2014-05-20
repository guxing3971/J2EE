package dnzl.YunXing;

import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_ESB_SuperClass;
import dnzl.DataFactory.XmlFactory;

/***********************************************
 * 断路器状态切换数据 
 *
 **********************************************/
public class Push_ESB_DLQZTQH extends Push_ESB_SuperClass{
	
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_DLQZT();
	}

	@Override
	public void initData() {
		List<String> list = null;
		try {
			list = xmlContents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list == null  || list.size() == 0){
			this.IsLog(false);
			this.IsNeed(false);
		}else{
			this.setXmlContents(list);
		}
	}
}
