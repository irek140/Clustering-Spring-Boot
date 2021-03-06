package pl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;
import pl.project.clusteringspringboot.datamining.data.AttributeDataType;
import pl.project.clusteringspringboot.datamining.data.CDMFilePhysicalDataSetFactory;
import pl.project.clusteringspringboot.datamining.data.CDMPhysicalAttributeFactory;
import pl.project.clusteringspringboot.datamining.data.PhysicalAttribute;
import pl.project.clusteringspringboot.datamining.resource.ConnectionSpec;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Piotr Lasek on 30.05.2017.
 */
public class DataSet {

    private final static Logger log = LogManager.getLogger(DataSet.class.getSimpleName());

    /**
     *
     * @param pdsf
     * @param cs
     * @return
     * @throws CDMException
     */
    public static PhysicalDataSet setAttributes(
            CDMFilePhysicalDataSetFactory pdsf, ConnectionSpec cs) throws CDMException {


        PhysicalDataSet fpds;
        fpds = pdsf.create("DMT Physical Data Set", false);

        // If the algorithm uses its own method to load the dataset return
        // empty physical data set!
        if (cs.getURI().contains("[CUSTOM]")) {
            fpds.setDescription(cs.getURI());
            return fpds;
        }

        Scanner sc = null;
        String line = null;
        Integer numberOfAttributes = null;
        File f = new File(cs.getURI());
        fpds.setDescription(f.getName());
        CDMPhysicalAttributeFactory paf = new CDMPhysicalAttributeFactory();

        try {
            sc = new Scanner(new File(cs.getURI()));
            line = sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Try to read number of attributes from a file
        try {
            log.info("Determining the number of attributes...");
            numberOfAttributes = new Integer(line);
            for(int i = 0; i < numberOfAttributes; i++) {
                PhysicalAttribute pa = paf.create("a" + i,
                        AttributeDataType.doubleType);
                fpds.addAttribute(pa);
            }
        } catch (Exception e) {
            log.warn("The number of attributes was not determined (1).");
        }

        // Try to determine number of attributes
        if (numberOfAttributes == null) {
            try {

                String[] attributes = null;

                attributes = line.split(",");

                if (attributes == null || attributes.length == 0) {
                    attributes = line.split(";");
                }

                if (attributes != null && attributes.length > 0) {

                    for(int i = 0; i < attributes.length; i++) {
                        PhysicalAttribute pa = paf.create(attributes[i].trim(),
                                AttributeDataType.doubleType);
                        fpds.addAttribute(pa);
                    }
                }
                log.info("Number of attributes: " + fpds.getAttributeCount());
            } catch (Exception e) {
                log.warn("WARNING: Number of attributes not determined (2).");
            }
        }

        return fpds;
    }
}
