package repositories;

import android.content.Context;

import org.w3c.dom.Element;

import models.employees.CareTaker;
import models.employees.Employee;
import services.factories.Constants;

public class EmployeeRepository extends EntityRepository<Employee> {
    private static final String XML_FILENAME = "Employees.xml";

    public EmployeeRepository(Context context) {
        super(XML_FILENAME, Constants.XML_TAGS.EMPLOYEE, context);
    }

    protected Employee getEntityFromXmlElement(Element element) {

        String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
        switch (discriminant) {
            case Constants.Employees.Caretaker:
                Employee caretaker = new CareTaker();
                caretaker.decodeFromXml(element);
                return caretaker;
            default:
                break;
        }
        return null;
    }

}