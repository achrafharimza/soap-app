package com.concretepage.converter;



import com.concretepage.service.IArticleService;
import org.hibernate.internal.util.xml.XmlDocument;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.StringReader;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@Service
public class ConverterService {
    private static final String NAMESPACE_URI = "http://schemas.xmlsoap.org/soap/envelope/";
    @Autowired
    private IArticleService articleService;


    public String  JsonToSoap ( ){
        String json = "{getArticleByIdRequest : { articleId:1}}";


        JSONObject jsonObject = new JSONObject(json);
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns=\"http://www.concretepage.com/article-ws\">\n"+
                "<soapenv:Header/>\n"+
                " <soapenv:Body>\n" +
               XML.toString(jsonObject) +
                "\n</soapenv:Body>\n" +
                "</soapenv:Envelope> ";
        System.out.printf("\n"+"  XML.toString(jsonObject)11 = "+  XML.toString(jsonObject)+"\n");


        String soapEndpointUrl = "http://localhost:9898/soapws/articles.wsdl ";
        String soapAction = "http://www.concretepage.com/article-ws";
        callSoapWebService(soapEndpointUrl, soapAction);
        return xml;



    }
    /*
     The example below requests from the Web Service at:
      https://www.w3schools.com/xml/tempconvert.asmx?op=CelsiusToFahrenheit


     To call other WS, change the parameters below, which are:
      - the SOAP Endpoint URL (that is, where the service is responding from)
      - the SOAP Action

     Also change the contents of the method createSoapEnvelope() in this class. It constructs
      the inner part of the SOAP envelope that is actually sent.
  */




    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException, ParserConfigurationException, IOException, SAXException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "art";
        String myNamespaceURI = "http://www.concretepage.com/article-ws";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.concretepage.com/article-ws">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:CelsiusToFahrenheit>
                        <myNamespace:Celsius>100</myNamespace:Celsius>
                    </myNamespace:CelsiusToFahrenheit>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */

        // SOAP Body
        String json = "{getArticleByIdRequest : {articleId:1}}";
        JSONObject jsonObject = new JSONObject(json);
        SOAPBody soapBody = envelope.getBody();
        String rawXml= XML.toString(jsonObject);
        soapBody.setTextContent(rawXml);
//        soapBody.setValue(rawXml);

//        soapBody.addDocument(doc);
//        soapBody.setTextContent(XML.toString(jsonObject));



                 System.out.printf("\n"+"  XML.toString(jsonObject)22 = "+  XML.toString(jsonObject)+"\n");


         SOAPElement soapBodyElem = soapBody.addChildElement("getArticleByIdRequest", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("articleId", myNamespace);
        soapBodyElem1.addTextNode("2");
    }

    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();
//

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

//        SOAPBody body =soapMessage.getSOAPBody();
//        body.setEncodingStyle();

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
//        soapMessage.getSOAPBody().setTextContent("<getArticleByIdRequest><articleId>1</articleId></getArticleByIdRequest>");
        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }











    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//Following method will  to convert String to XML Document
private static Document convertStringToXMLDoc(String strXMLValue)
{

    try
    {
        //Create a new object of DocumentBuilderFactory
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();

        //Create an object DocumentBuilder to parse the specified XML Data
        DocumentBuilder builder = dbfactory.newDocumentBuilder();

        //Parse the content to Document object
        Document doc = builder.parse(new InputSource(new StringReader(strXMLValue)));
        return doc;
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return null;
}
}


