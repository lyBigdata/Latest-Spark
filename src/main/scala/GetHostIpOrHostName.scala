import java.net.{UnknownHostException, InetAddress}

import org.slf4j.LoggerFactory

/**
  *
  *
  * <pre>
  * User: liuyu
  * Date: 2016/10/9
  * Time: 11:51
  * </pre>
  *
  * @author liuyu
  */
class GetHostIpOrHostName {

	val logger = LoggerFactory.getLogger(this.getClass)

	def getInetAddress():InetAddress={
		try{
			val host: InetAddress = InetAddress.getLocalHost()
			return host
		}catch{
			case unknownEx:UnknownHostException =>logger.warn("unknown host ..."+unknownEx.printStackTrace())
			case e:Exception => logger.warn("其他未可预料异常。。。"+e.printStackTrace())
		}
		null
	}

	/**
	  * 获得当前的主机ip
	  * @param netAddress
	  * @return
	  */
	def  getHostIp(netAddress:InetAddress ):String={
		if(null == netAddress){
			return null
		}
		netAddress.getHostAddress();
	}

	/**
	  * 获取当前的主机名
	  * @param netAddress
	  * @return
	  */
	def   getHostName( netAddress:InetAddress):String={
		if(null == netAddress){
			return null;
		}
		netAddress.getHostName()
	}
}

object main extends App{
	private val name: GetHostIpOrHostName = new GetHostIpOrHostName()
	private val address: InetAddress = name.getInetAddress()
	println(name.getHostIp(address))
	println(name.getHostName(address))
}
