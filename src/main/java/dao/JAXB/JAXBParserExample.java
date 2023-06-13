package dao.JAXB;

import dao.Models.*;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;
import java.util.List;

public class JAXBParserExample {
    public static void main(String[] args) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Farmstead.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();


            File xmlFile = new File("/Users/dylannelson16/IdeaProjects/Farm/src/main/java/dao/Resources/xml/Farm.xml");


            Farmstead farmstead = (Farmstead) unmarshaller.unmarshal(xmlFile);


            int farmId = farmstead.getFarmId();
            String farmName = farmstead.getName();
            List<Animal> animals = farmstead.getAnimals();
            Date dateCreated = farmstead.getDateCreated();



        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

