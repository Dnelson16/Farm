package dao.Resources.SAX;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class SAXParserExample {

    public static void main(String[] args) {
        try {
            // Path to the XML file to parse
            String xmlFilePath = "/Users/dylannelson16/IdeaProjects/Farm/src/main/java/dao/Resources/Farm.xml";

            // Path to the XSD schema file
            String xsdFilePath = "/Users/dylannelson16/IdeaProjects/Farm/src/main/java/dao/Resources/Farm.xsd";

            // Validate the XML file against the XSD schema
            boolean isValid = validateXML(xmlFilePath, xsdFilePath);
            if (isValid) {
                System.out.println("XML file is valid.");
            } else {
                System.out.println("XML file is not valid.");
            }

            // Parse the XML file using SAX parser
            parseXML(xmlFilePath);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateXML(String xmlFilePath, String xsdFilePath) throws SAXException, IOException {
        // Create a SchemaFactory and specify the XML schema language
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // Load the XSD schema
        Schema schema = schemaFactory.newSchema(new File(xsdFilePath));

        // Create a Validator instance
        Validator validator = schema.newValidator();

        // Validate the XML file against the schema
        validator.validate(new StreamSource(new File(xmlFilePath)));

        return true;
    }

    private static void parseXML(String xmlFilePath) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Create a SAXParser instance
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // Create a custom handler to handle XML parsing events
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                // Handle start element event
                System.out.println("Start Element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                // Handle end element event
                System.out.println("End Element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                // Handle character data event
                String text = new String(ch, start, length);
                System.out.println("Character Data: " + text);
            }
        };

        // Parse the XML file using the SAX parser and custom handler
        saxParser.parse(new File(xmlFilePath), handler);
    }
}
