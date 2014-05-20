package dnzl.YunXing;
/***************************************************
 * 主要功能:
 * 	用于推送母线状态切换数据信息
 *
 ***************************************************/


import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_ESB_SuperClass;
import dnzl.DataFactory.XmlFactory;


public class Push_ESB_MXZTQH extends Push_ESB_SuperClass{
	
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_MXZT();
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
