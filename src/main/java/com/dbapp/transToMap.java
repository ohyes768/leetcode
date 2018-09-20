package com.dbapp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.FileOutputStream;
import java.util.Map;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/9/4 10:56
 * @Modified:
 */
public class transToMap {

    public static void main(String[] args) {
        String input = "[  {\n" +
                "  \"modelName\" : \"1101\",\n" +
                "  \"chineseName\" : \"违规请求\",\n" +
                "  \"description\" : \"发现可疑的非正常http请求。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1102\",\n" +
                "  \"chineseName\" : \"HTTP请求版本限制\",\n" +
                "  \"description\" : \"发现请求非正常的http版本。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1103\",\n" +
                "  \"chineseName\" : \"HTTP请求头限制\",\n" +
                "  \"description\" : \"发现非正常的http请求，使用不完整的请求头。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1104\",\n" +
                "  \"chineseName\" : \"HTTP请求方法限制\",\n" +
                "  \"description\" : \"发现非正常的http请求方法，可能是探测攻击行为。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1105\",\n" +
                "  \"chineseName\" : \"异常HTTP请求\",\n" +
                "  \"description\" : \"发现异常的HTTP请求，请求头中带有非正常的参数。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1106\",\n" +
                "  \"chineseName\" : \"HTTP请求资源限制\",\n" +
                "  \"description\" : \"HTTP报文头中发现异常的资源请求，尝试访问服务器文件。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1107\",\n" +
                "  \"chineseName\" : \"HTTP请求头限制\",\n" +
                "  \"description\" : \"HTTP请求头不符合规范，缺少参数或超出正常长度。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1201\",\n" +
                "  \"chineseName\" : \"SQL注入\",\n" +
                "  \"description\" : \"发现SQL注入攻击尝试，攻击者在请求中嵌入恶意SQL注入语句，尝试获取、修改服务器数据库，甚至执行操作系统指令。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作，对用户输入进行检查和转义，并且避免使用字符串拼接等不安全的数据库请求语句。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"SQLInjection\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1202\",\n" +
                "  \"chineseName\" : \"SQL盲注\",\n" +
                "  \"description\" : \"发现SQL盲注攻击尝试，尽管数据库敏感内容不在前端显示，但是攻击者可通过精心构造的语句和网页响应状态猜解数据库内容，从而窃取数据或执行远程命令。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作，对用户输入进行检查和转义，并且避免使用字符串拼接等不安全的数据库请求语句。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"SQLInjection\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1203\",\n" +
                "  \"chineseName\" : \"命令注入\",\n" +
                "  \"description\" : \"发现请求中包含恶意PHP代码，可能是攻击者尝试执行远程指令，获取服务器权限。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作，对用户输入进行检查和转义，避免将参数直接传入代码执行系统命令。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"codeInjection\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1204\",\n" +
                "  \"chineseName\" : \"系统命令注入\",\n" +
                "  \"description\" : \"发现请求中包含恶意系统命令，可能是攻击者尝试执行远程指令，获取服务器权限。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作，对用户输入进行检查和转义，避免将参数直接传入代码执行系统命令。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"commandInjection\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1205\",\n" +
                "  \"chineseName\" : \"文件注入\",\n" +
                "  \"description\" : \"攻击者尝试访问或调用服务器文件，从而窃取信息和控制远程系统。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作和权限控制，对用户输入进行检查和转义，禁止用户请求敏感目录。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1206\",\n" +
                "  \"chineseName\" : \"LDAP注入\",\n" +
                "  \"description\" : \"发现请求中包含恶意LDAP注入代码，该行为可用于修改查询逻辑以绕过安全性检查，或者插入其他用于修改后端数据库的语句，或执行系统命令。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施，修改相关业务编码方式。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1207\",\n" +
                "  \"chineseName\" : \"SSI代码注入\",\n" +
                "  \"description\" : \"SSI是嵌入HTML页面中的指令，在页面被提供时由服务器进行运算，以对现有HTML页面增加动态生成的内容，而无须通过CGI程序提供其整个页面，或者使用其他动态技术。攻击者可以通过注释行调用的命令或指针，即允许通过在HTML页面注入脚本或远程执行任意代码。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施，关闭服务器SSI功能或过滤相关SSI特殊字符。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1299\",\n" +
                "  \"chineseName\" : \"捕获非正常的文件名、参数名和参数\",\n" +
                "  \"description\" : \"请求的参数或参数名当中包含可疑注入代码。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"injectionAttack\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1301\",\n" +
                "  \"chineseName\" : \"XSS跨站脚本攻击\",\n" +
                "  \"description\" : \"发现请求中包含恶意XSS语句，若web应用存在该漏洞，攻击者可利用来盗取用户标识、篡改网页等。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作，对用户输入输出进行检查和转义，过滤<>script等关键字。代码和数据严格分离。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"crossSiteAttack\",\n" +
                "  \"attackMethod\" : \"XSS\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1302\",\n" +
                "  \"chineseName\" : \"XSS跨站脚本攻击\",\n" +
                "  \"description\" : \"发现请求中包含恶意XSS语句，若web应用存在该漏洞，攻击者可利用来盗取用户标识、篡改网页等。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作，对用户输入输出进行检查和转义，过滤<>script等关键字。代码和数据严格分离。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"crossSiteAttack\",\n" +
                "  \"attackMethod\" : \"XSS\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1399\",\n" +
                "  \"chineseName\" : \"PDF跨站攻击\",\n" +
                "  \"description\" : \"发现针对pdf资源文件的XSS攻击尝试。若web应用存在该漏洞，攻击者可利用来盗取用户标识、强制重定向等。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好验证操作，对用户输入输出进行检查和转义，过滤<>script等关键字。代码和数据严格分离。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"crossSiteAttack\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1401\",\n" +
                "  \"chineseName\" : \"HTTP请求分割攻击\",\n" +
                "  \"description\" : \"发现HTTP请求分割攻击，Content-Length与Transfer-Encoding两个字段存在异常。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1402\",\n" +
                "  \"chineseName\" : \"HTTP响应分割攻击\",\n" +
                "  \"description\" : \"发现HTTP响应分割攻击，攻击者尝试根据服务器响应变化，挖掘特定漏洞。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1403\",\n" +
                "  \"chineseName\" : \"会话定置攻击\",\n" +
                "  \"description\" : \"HTTP请求疑似为定置攻击，攻击者精心构造cookie，尝试访问特殊资源。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。规范用户session授权范围，可以有效地消除session定置攻击。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1499\",\n" +
                "  \"chineseName\" : \"会话定置攻击\",\n" +
                "  \"description\" : \"HTTP请求疑似为定置攻击，攻击者精心构造cookie，尝试访问特殊资源。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。规范用户session授权范围，可以有效地消除session定置攻击。\",\n" +
                "  \"killChain\" : \"Penetration Attack\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"malAction\",\n" +
                "  \"attackMethod\" : \"webMalAction\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1501\",\n" +
                "  \"chineseName\" : \"WEBSHELL特征检测\",\n" +
                "  \"description\" : \"检测到webshell特征，攻击者尝试读取或写入webshell后门文件，从而获取服务器权限。\",\n" +
                "  \"suggest\" : \"建议网络管理员自查web应用是否存在相关上传漏洞，并确认服务器相关目录下是否存在可疑文件，及时清理并修复漏洞。\",\n" +
                "  \"killChain\" : \"Obtain Permission\",\n" +
                "  \"attackIntent\" : \"maliciousFile\",\n" +
                "  \"attackStrategy\" : \"backdoor\",\n" +
                "  \"attackMethod\" : \"webshell\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1599\",\n" +
                "  \"chineseName\" : \"恶意软件攻击\",\n" +
                "  \"description\" : \"攻击者尝试访问或写入恶意文件，从而获取服务器权限。\",\n" +
                "  \"suggest\" : \"建议网络管理员自查web应用是否存在相关上传漏洞，并确认服务器相关目录下是否存在可疑文件，及时清理并修复漏洞。\",\n" +
                "  \"killChain\" : \"Obtain Permission\",\n" +
                "  \"attackIntent\" : \"maliciousFile\",\n" +
                "  \"attackStrategy\" : \"backdoor\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"High\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1601\",\n" +
                "  \"chineseName\" : \"防目录信息泄露检测\",\n" +
                "  \"description\" : \"攻击者尝试访问服务器特定目录，如git和svn目录。从而窃取应用目录下文件。\",\n" +
                "  \"suggest\" : \"WEB应用需要控制好权限，相关仓库目录和测试文件不随着项目一起发布。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"infoLeakage\",\n" +
                "  \"attackMethod\" : \"dirInfoLeakage\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1602\",\n" +
                "  \"chineseName\" : \"防特定服务信息泄露检测\",\n" +
                "  \"description\" : \"攻击者针对特定服务（如IIS）发起攻击，尝试猜解目录结构，非法获取数据。\",\n" +
                "  \"suggest\" : \"WEB服务中间件尽量选择稳定安全的版本，同时做好权限控制。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"infoLeakage\",\n" +
                "  \"attackMethod\" : \"webLeakage\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1603\",\n" +
                "  \"chineseName\" : \"数据库错误信息泄露\",\n" +
                "  \"description\" : \"服务器的返回内容中包含数据库报错信息，攻击者可利用该类信息获知数据库类型及版本。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好异常处理机制，相关数据库请求错误不建议在前端展示，因为容易被攻击者利用来猜解服务类型及版本。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"infoLeakage\",\n" +
                "  \"attackMethod\" : \"DBLeakage\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1604\",\n" +
                "  \"chineseName\" : \"源码泄露检测\",\n" +
                "  \"description\" : \"服务器的返回内容中包含源码信息，攻击者可利用该类信息获知web应用的细节信息。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好异常处理机制，因用户输入导致程序产生错误时，不在前端显示具体细节。同时，若无特殊需求，含有任何源码的文件都增加访问限制策略。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"infoLeakage\",\n" +
                "  \"attackMethod\" : \"sourceCodeInfoLeakage\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1699\",\n" +
                "  \"chineseName\" : \"服务信息泄露检测\",\n" +
                "  \"description\" : \"服务器的返回内容中包含中间件消息，攻击者可利用该类信息获知web应用的细节信息。\",\n" +
                "  \"suggest\" : \"WEB应用需要做好异常处理机制，因用户输入导致程序产生错误时，不在前端显示具体细节。同时，若无特殊需求，含有任何服务消息的文件都增加访问限制策略。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"infoLeakage\",\n" +
                "  \"attackMethod\" : \"webLeakage\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1701\",\n" +
                "  \"chineseName\" : \"扫描攻击特征检测\",\n" +
                "  \"description\" : \"检测到漏洞扫描行为特征，通常是web漏洞扫描程序和脚本进行的动作。\",\n" +
                "  \"suggest\" : \"由于该类行为会对服务器造成较大负荷，建议网络管理员保持关注，若发现单个IP访问量过大，建议加入黑名单，限制其访问。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"scanProbe\",\n" +
                "  \"attackStrategy\" : \"webProbe\",\n" +
                "  \"attackMethod\" : \"webScan\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1702\",\n" +
                "  \"chineseName\" : \"扫描攻击特征检测\",\n" +
                "  \"description\" : \"检测到漏洞扫描行为特征，通常是web漏洞扫描程序和脚本进行的动作。\",\n" +
                "  \"suggest\" : \"由于该类行为会对服务器造成较大负荷，建议网络管理员保持关注，若发现单个IP访问量过大，建议加入黑名单，限制其访问。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"scanProbe\",\n" +
                "  \"attackStrategy\" : \"webProbe\",\n" +
                "  \"attackMethod\" : \"webScan\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"1801\",\n" +
                "  \"chineseName\" : \"漏洞攻击检测\",\n" +
                "  \"description\" : \"检测到针对常见web应用框架的攻击，攻击者利用网络上公开的代码，尝试对web应用进行攻击探测。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"vulnerabilityExploitation\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"TRUE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"0006\",\n" +
                "  \"chineseName\" : \"常规漏洞探测行为\",\n" +
                "  \"description\" : \"检测到常规漏洞探测行为，通常是黑客扫描脚本导致。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"vulnerabilityExploitation\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"0005\",\n" +
                "  \"chineseName\" : \"常规漏洞探测行为\",\n" +
                "  \"description\" : \"检测到常规漏洞探测行为，通常是黑客扫描脚本导致。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"vulnerabilityExploitation\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"0004\",\n" +
                "  \"chineseName\" : \"常规漏洞探测行为\",\n" +
                "  \"description\" : \"检测到常规漏洞探测行为，通常是黑客扫描脚本导致。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"vulnerabilityExploitation\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"0003\",\n" +
                "  \"chineseName\" : \"常规漏洞探测行为\",\n" +
                "  \"description\" : \"检测到常规漏洞探测行为，通常是黑客扫描脚本导致。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"vulnerabilityExploitation\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"0002\",\n" +
                "  \"chineseName\" : \"常规漏洞探测行为\",\n" +
                "  \"description\" : \"检测到常规漏洞探测行为，通常是黑客扫描脚本导致。\",\n" +
                "  \"suggest\" : \"建议网络管理员保持关注，若发现针对性攻击，自查web应用是否存在相关漏洞，及时采取措施。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"exploitAttack\",\n" +
                "  \"attackStrategy\" : \"vulnerabilityExploitation\",\n" +
                "  \"attackMethod\" : \"others\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "}, {\n" +
                "  \"modelName\" : \"0001\",\n" +
                "  \"chineseName\" : \"漏洞扫描器行为\",\n" +
                "  \"description\" : \"检测到扫描器行为特征，通常是安全机构的web漏洞扫描程序和脚本进行的动作。\",\n" +
                "  \"suggest\" : \"由于该类行为会对服务器造成较大负荷，建议网络管理员保持关注，若发现单个IP访问量过大，建议加入黑名单，限制其访问。\",\n" +
                "  \"killChain\" : \"Scanning & Probing\",\n" +
                "  \"attackIntent\" : \"scanProbe\",\n" +
                "  \"attackStrategy\" : \"webProbe\",\n" +
                "  \"attackMethod\" : \"webScan\",\n" +
                "  \"threatSeverity\" : \"Medium\",\n" +
                "  \"modelType\" : \"rule\",\n" +
                "  \"dataSource\" : \"security_logs\",\n" +
                "  \"toAlarm\" : \"FALSE\",\n" +
                "  \"enable\" : \"TRUE\"\n" +
                "} ]";

        String x = "{\n" +
                "    \"0\": {\n" +
                "        \"deviceId\": \"Scanning & Probing\",\n" +
                "        \"deviceName\": \"ailpha\"\n" +
                "    },\n" +
                "    \"0001\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"webScan\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"webProbe\"\n" +
                "    },\n" +
                "    \"0002\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"serviceScan\"\n" +
                "    },\n" +
                "    \"0003\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"0004\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"0005\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"0006\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"10000001\": {\n" +
                "        \"name\": \"恶意访问者攻击\",\n" +
                "        \"ruleId\": \"10000001\",\n" +
                "        \"ruleName\": \"恶意访问者攻击\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"webMalAction\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"malAction\"\n" +
                "    },\n" +
                "    \"10000002\": {\n" +
                "        \"name\": \"CC攻击\",\n" +
                "        \"ruleId\": \"10000002\",\n" +
                "        \"ruleName\": \"CC攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"CCAttack\",\n" +
                "        \"superWarningType\": \"DoS\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"connectionAttack\"\n" +
                "    },\n" +
                "    \"10000004\": {\n" +
                "        \"name\": \"扫描行为攻击\",\n" +
                "        \"ruleId\": \"10000004\",\n" +
                "        \"ruleName\": \"扫描行为攻击\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"webScan\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"webProbe\"\n" +
                "    },\n" +
                "    \"10000005\": {\n" +
                "        \"name\": \"潜伏型应用攻击\",\n" +
                "        \"ruleId\": \"10000005\",\n" +
                "        \"ruleName\": \"潜伏型应用攻击\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"DBLeakage\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"infoLeakage\"\n" +
                "    },\n" +
                "    \"10000006\": {\n" +
                "        \"name\": \"木马行为检测\",\n" +
                "        \"ruleId\": \"10000006\",\n" +
                "        \"ruleName\": \"木马行为检测\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"trojan\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"botnetTrojanWorm\"\n" +
                "    },\n" +
                "    \"10000007\": {\n" +
                "        \"name\": \"Webshell行为检测\",\n" +
                "        \"ruleId\": \"10000007\",\n" +
                "        \"ruleName\": \"Webshell行为检测\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"webshell\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"backdoor\"\n" +
                "    },\n" +
                "    \"10000008\": {\n" +
                "        \"name\": \"DGA回连行为检测\",\n" +
                "        \"ruleId\": \"10000008\",\n" +
                "        \"ruleName\": \"DGA回连行为检测\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"domainBackConnect\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"botnetTrojanWorm\"\n" +
                "    },\n" +
                "    \"10000009\": {\n" +
                "        \"name\": \"C&C域名检测\",\n" +
                "        \"ruleId\": \"10000009\",\n" +
                "        \"ruleName\": \"C&C域名检测\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"domainBackConnect\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"botnetTrojanWorm\"\n" +
                "    },\n" +
                "    \"10000011\": {\n" +
                "        \"ruleId\": \"10000011\",\n" +
                "        \"ruleName\": \"漏洞利用\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"vulnerability\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"10000012\": {\n" +
                "        \"ruleId\": \"10000012\",\n" +
                "        \"ruleName\": \"漏洞利用成功\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"vulnerability\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"10000110\": {\n" +
                "        \"name\": \"恶意文件攻击\",\n" +
                "        \"ruleId\": \"10000110\",\n" +
                "        \"ruleName\": \"恶意文件攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"apt\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"10000121\": {\n" +
                "        \"name\": \"SMB远程溢出攻击\",\n" +
                "        \"ruleId\": \"10000121\",\n" +
                "        \"ruleName\": \"SMB远程溢出攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"apt\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"10000204\": {\n" +
                "        \"name\": \"SYN泛洪攻击\",\n" +
                "        \"ruleId\": \"10000204\",\n" +
                "        \"ruleName\": \"SYN泛洪攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"SYNFlood\",\n" +
                "        \"superWarningType\": \"DoS\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"connectionAttack\"\n" +
                "    },\n" +
                "    \"10000205\": {\n" +
                "        \"name\": \"UDP泛洪攻击\",\n" +
                "        \"ruleId\": \"10000205\",\n" +
                "        \"ruleName\": \"UDP泛洪攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"UDPFlood\",\n" +
                "        \"superWarningType\": \"DoS\",\n" +
                "        \"warningSource\": \"scene\",\n" +
                "        \"warningType\": \"connectionAttack\"\n" +
                "    },\n" +
                "    \"1101\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"1102\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"1103\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"1104\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"1105\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"1106\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"1107\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"protocolAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"trafficAnomaly\"\n" +
                "    },\n" +
                "    \"1201\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"SQLInjection\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1202\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"SQLInjection\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1203\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"codeInjection\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1204\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"commandInjection\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1205\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1206\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1207\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1299\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"1301\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"XSS\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"crossSiteAttack\"\n" +
                "    },\n" +
                "    \"1302\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"crossSiteAttack\"\n" +
                "    },\n" +
                "    \"1399\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"crossSiteAttack\"\n" +
                "    },\n" +
                "    \"1401\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"1402\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"1403\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"1499\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"1501\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"webshell\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"backdoor\"\n" +
                "    },\n" +
                "    \"1599\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"trojan\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"botnetTrojanWorm\"\n" +
                "    },\n" +
                "    \"1601\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"dirInfoLeakage\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"infoLeakage\"\n" +
                "    },\n" +
                "    \"1602\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"webLeakage\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"infoLeakage\"\n" +
                "    },\n" +
                "    \"1603\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"DBLeakage\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"infoLeakage\"\n" +
                "    },\n" +
                "    \"1604\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"infoLeakage\"\n" +
                "    },\n" +
                "    \"1699\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"infoLeakage\"\n" +
                "    },\n" +
                "    \"1701\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"webScan\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"webProbe\"\n" +
                "    },\n" +
                "    \"1702\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"webCrawler\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"webProbe\"\n" +
                "    },\n" +
                "    \"1801\": {\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"rule\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"20010100\": {\n" +
                "        \"name\": \"绕过防火墙\",\n" +
                "        \"ruleId\": \"20010100\",\n" +
                "        \"ruleName\": \"绕过防火墙\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"bypassDevice\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"crossPrivilege\"\n" +
                "    },\n" +
                "    \"20020100\": {\n" +
                "        \"name\": \"操作系统暴力破解成功\",\n" +
                "        \"ruleId\": \"20020100\",\n" +
                "        \"ruleName\": \"操作系统暴力破解成功0\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"bruteForce\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"passwordCracking\"\n" +
                "    },\n" +
                "    \"20020101\": {\n" +
                "        \"name\": \"操作系统暴力破解成功\",\n" +
                "        \"ruleId\": \"20020101\",\n" +
                "        \"ruleName\": \"操作系统暴力破解成功1\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"bruteForce\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"passwordCracking\"\n" +
                "    },\n" +
                "    \"20020102\": {\n" +
                "        \"name\": \"操作系统暴力破解成功\",\n" +
                "        \"ruleId\": \"20020102\",\n" +
                "        \"ruleName\": \"操作系统暴力破解成功2\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"bruteForce\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"passwordCracking\"\n" +
                "    },\n" +
                "    \"20020200\": {\n" +
                "        \"name\": \"VPN暴力破解成功\",\n" +
                "        \"ruleId\": \"20020200\",\n" +
                "        \"ruleName\": \"VPN暴力破解成功\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"bruteForce\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"passwordCracking\"\n" +
                "    },\n" +
                "    \"20030100\": {\n" +
                "        \"name\": \"端口批量扫描\",\n" +
                "        \"ruleId\": \"20030100\",\n" +
                "        \"ruleName\": \"端口批量扫描\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"portScan\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"hostScan\"\n" +
                "    },\n" +
                "    \"20030200\": {\n" +
                "        \"name\": \"SQL漏洞扫描\",\n" +
                "        \"ruleId\": \"20030200\",\n" +
                "        \"ruleName\": \"SQL漏洞扫描\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"webScan\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"webProbe\"\n" +
                "    },\n" +
                "    \"20030300\": {\n" +
                "        \"name\": \"主机漏洞扫描\",\n" +
                "        \"ruleId\": \"20030300\",\n" +
                "        \"ruleName\": \"主机漏洞扫描\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Scanning & Probing\",\n" +
                "        \"subWarningType\": \"other\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"hostScan\"\n" +
                "    },\n" +
                "    \"20030400\": {\n" +
                "        \"name\": \"sqlmap漏洞扫描\",\n" +
                "        \"ruleId\": \"20030400\",\n" +
                "        \"ruleName\": \"sqlmap漏洞扫描\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"webScan\",\n" +
                "        \"superWarningType\": \"scanProbe\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"webProbe\"\n" +
                "    },\n" +
                "    \"20040100\": {\n" +
                "        \"name\": \"IP伪装\",\n" +
                "        \"ruleId\": \"20040100\",\n" +
                "        \"ruleName\": \"IP伪装\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"IPSpoofing\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"spoofingAttack\"\n" +
                "    },\n" +
                "    \"20050100\": {\n" +
                "        \"name\": \"批量操作失败\",\n" +
                "        \"ruleId\": \"20050100\",\n" +
                "        \"ruleName\": \"批量操作失败\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"operationAnomaly\",\n" +
                "        \"superWarningType\": \"anomalyEvent\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"operationAnomaly\"\n" +
                "    },\n" +
                "    \"20060100\": {\n" +
                "        \"name\": \"webshell植入破坏\",\n" +
                "        \"ruleId\": \"20060100\",\n" +
                "        \"ruleName\": \"webshell植入破坏0\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"webshell\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"backdoor\"\n" +
                "    },\n" +
                "    \"20060101\": {\n" +
                "        \"name\": \"webshell植入破坏\",\n" +
                "        \"ruleId\": \"20060101\",\n" +
                "        \"ruleName\": \"webshell植入破坏1\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"webshell\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"backdoor\"\n" +
                "    },\n" +
                "    \"20060200\": {\n" +
                "        \"name\": \"msf反弹shell\",\n" +
                "        \"ruleId\": \"20060200\",\n" +
                "        \"ruleName\": \"msf反弹shell\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"hostBackdoor\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"backdoor\"\n" +
                "    },\n" +
                "    \"20060300\": {\n" +
                "        \"name\": \"DNSShell反弹\",\n" +
                "        \"ruleId\": \"20060300\",\n" +
                "        \"ruleName\": \"DNSShell反弹\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"hostBackdoor\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"backdoor\"\n" +
                "    },\n" +
                "    \"20070100\": {\n" +
                "        \"name\": \"ARP欺骗\",\n" +
                "        \"ruleId\": \"20070100\",\n" +
                "        \"ruleName\": \"ARP欺骗\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"ARP\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"spoofingAttack\"\n" +
                "    },\n" +
                "    \"20070200\": {\n" +
                "        \"name\": \"DNS欺骗攻击\",\n" +
                "        \"ruleId\": \"20070200\",\n" +
                "        \"ruleName\": \"DNS欺骗攻击\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"DNSSpoofing\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"spoofingAttack\"\n" +
                "    },\n" +
                "    \"20080100\": {\n" +
                "        \"name\": \"邮件发送数异常\",\n" +
                "        \"ruleId\": \"20080100\",\n" +
                "        \"ruleName\": \"邮件发送数异常\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"emailMalAction\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"malAction\"\n" +
                "    },\n" +
                "    \"20080200\": {\n" +
                "        \"name\": \"垃圾邮件\",\n" +
                "        \"ruleId\": \"20080200\",\n" +
                "        \"ruleName\": \"垃圾邮件\",\n" +
                "        \"severity\": 6,\n" +
                "        \"killChain\": \"Penetration Attack\",\n" +
                "        \"subWarningType\": \"emailMalAction\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"malAction\"\n" +
                "    },\n" +
                "    \"20080300\": {\n" +
                "        \"name\": \"邮件炸弹\",\n" +
                "        \"ruleId\": \"20080300\",\n" +
                "        \"ruleName\": \"邮件炸弹\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"emailMalAction\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"malAction\"\n" +
                "    },\n" +
                "    \"20080400\": {\n" +
                "        \"name\": \"电子邮件伪造\",\n" +
                "        \"ruleId\": \"20080400\",\n" +
                "        \"ruleName\": \"电子邮件伪造\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"other\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"spoofingAttack\"\n" +
                "    },\n" +
                "    \"20090100\": {\n" +
                "        \"name\": \"夜龙APT攻击\",\n" +
                "        \"ruleId\": \"20090100\",\n" +
                "        \"ruleName\": \"夜龙APT攻击0\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"nightDragon\",\n" +
                "        \"superWarningType\": \"APT\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"APT\"\n" +
                "    },\n" +
                "    \"20090101\": {\n" +
                "        \"name\": \"夜龙APT攻击\",\n" +
                "        \"ruleId\": \"20090101\",\n" +
                "        \"ruleName\": \"夜龙APT攻击1\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"nightDragon\",\n" +
                "        \"superWarningType\": \"APT\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"APT\"\n" +
                "    },\n" +
                "    \"20090200\": {\n" +
                "        \"name\": \"蔓灵花APT\",\n" +
                "        \"ruleId\": \"20090200\",\n" +
                "        \"ruleName\": \"蔓灵花APT\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"other\",\n" +
                "        \"superWarningType\": \"APT\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"APT\"\n" +
                "    },\n" +
                "    \"20090300\": {\n" +
                "        \"name\": \"Necurs Botnet Malspam攻击\",\n" +
                "        \"ruleId\": \"20090300\",\n" +
                "        \"ruleName\": \"Necurs Botnet Malspam攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"other\",\n" +
                "        \"superWarningType\": \"APT\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"APT\"\n" +
                "    },\n" +
                "    \"20090400\": {\n" +
                "        \"name\": \"Nitro攻击\",\n" +
                "        \"ruleId\": \"20090400\",\n" +
                "        \"ruleName\": \"Nitro攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"other\",\n" +
                "        \"superWarningType\": \"APT\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"APT\"\n" +
                "    },\n" +
                "    \"20090500\": {\n" +
                "        \"name\": \"Hancitor Malspam攻击\",\n" +
                "        \"ruleId\": \"20090500\",\n" +
                "        \"ruleName\": \"Hancitor Malspam攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"other\",\n" +
                "        \"superWarningType\": \"APT\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"APT\"\n" +
                "    },\n" +
                "    \"20100100\": {\n" +
                "        \"name\": \"SQL注入成功\",\n" +
                "        \"ruleId\": \"20100100\",\n" +
                "        \"ruleName\": \"SQL注入成功0\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"SQLInjection\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"20100101\": {\n" +
                "        \"name\": \"SQL注入成功\",\n" +
                "        \"ruleId\": \"20100101\",\n" +
                "        \"ruleName\": \"SQL注入成功1\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Obtain Permission\",\n" +
                "        \"subWarningType\": \"SQLInjection\",\n" +
                "        \"superWarningType\": \"exploitAttack\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"injectionAttack\"\n" +
                "    },\n" +
                "    \"20110100\": {\n" +
                "        \"name\": \"木马入侵\",\n" +
                "        \"ruleId\": \"20110100\",\n" +
                "        \"ruleName\": \"木马入侵\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"trojan\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"botnetTrojanWorm\"\n" +
                "    },\n" +
                "    \"20120100\": {\n" +
                "        \"name\": \"拒绝服务攻击\",\n" +
                "        \"ruleId\": \"20120100\",\n" +
                "        \"ruleName\": \"拒绝服务攻击\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Asset Destruction\",\n" +
                "        \"subWarningType\": \"others\",\n" +
                "        \"superWarningType\": \"DoS\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"others\"\n" +
                "    },\n" +
                "    \"20130100\": {\n" +
                "        \"name\": \"病毒感染\",\n" +
                "        \"ruleId\": \"20130100\",\n" +
                "        \"ruleName\": \"病毒感染\",\n" +
                "        \"severity\": 9,\n" +
                "        \"killChain\": \"Command & Control\",\n" +
                "        \"subWarningType\": \"networkVirus\",\n" +
                "        \"superWarningType\": \"maliciousFile\",\n" +
                "        \"warningSource\": \"association\",\n" +
                "        \"warningType\": \"virus\"\n" +
                "    }\n" +
                "}";
        JSONArray jsonArray = JSON.parseArray(input);
        JSONObject needChageJson = JSONObject.parseObject(x);
        for (Object o : needChageJson.keySet()) {
            String key = o.toString();
            for (Object o1 : jsonArray) {
                JSONObject json = (JSONObject) o1;
                if(json.getString("modelName").equals(key)){
                    System.out.println(key + "---" + needChageJson.getJSONObject(key).getString("subWarningType") + "---" + json.getString("attackMethod"));
                    needChageJson.getJSONObject(key).put("subWarningType", json.getString("attackMethod"));
                    needChageJson.getJSONObject(key).put("warningType", json.getString("attackStrategy"));
                    needChageJson.getJSONObject(key).put("superWarningType", json.getString("attackIntent"));
                    needChageJson.getJSONObject(key).put("killChain", json.getString("killChain"));
                }
            }
        }
        String outputStr = JSON.toJSONString(needChageJson, SerializerFeature.PrettyFormat);
        writeFile("ruleIdMap.json", JSON.toJSONString(needChageJson, SerializerFeature.PrettyFormat));

        System.out.println(outputStr);
    }

    private static int setStageCodeByKillChain(String killChain){
        int stageCode = 0;
        switch(killChain){
            case "Scanning & Probing":stageCode=1;break;
            case "Penetration Attack":stageCode=2;break;
            case "Obtain Permission":stageCode=3;break;
            case "Command & Control":stageCode=4;break;
            case "Asset Destruction":stageCode=5;break;
        }
        return stageCode;
    }

    public static boolean writeFile(String filePath, String s) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(s.getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
