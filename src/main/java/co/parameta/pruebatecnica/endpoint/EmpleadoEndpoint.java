package co.parameta.pruebatecnica.endpoint;

import co.parameta.pruebatecnica.GuardarEmpleadoRequest;
import co.parameta.pruebatecnica.GuardarEmpleadoResponse;
import co.parameta.pruebatecnica.model.Empleado;
import co.parameta.pruebatecnica.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Endpoint
public class EmpleadoEndpoint {

    private static final String NAMESPACE_URI = "http://www.parameta.co/empleado";

    @Autowired
    private EmpleadoService empleadoDBService;

    @PayloadRoot(namespace = "http://www.parameta.co/empleado", localPart = "GuardarEmpleadoRequest")
    @ResponsePayload
    public GuardarEmpleadoResponse guardarEmpleado(@RequestPayload GuardarEmpleadoRequest request) {
        Empleado empleado = new Empleado();
        empleado.setNombres(request.getNombres());
        empleado.setApellidos(request.getApellidos());
        empleado.setTipoDocumento(request.getTipoDocumento());
        empleado.setNumeroDocumento(request.getNumeroDocumento());
        empleado.setFechaNacimiento(toDate(request.getFechaNacimiento()));
        empleado.setFechaVinculacion(toDate(request.getFechaVinculacion()));

        empleado.setCargo(request.getCargo());
        empleado.setSalario(request.getSalario());

        Empleado guardado = empleadoDBService.guardarEmpleado(empleado);

        GuardarEmpleadoResponse response = new GuardarEmpleadoResponse();


        response.setFechaNacimiento(convertDateToXMLGregorianCalendar(guardado.getFechaNacimiento()));
        response.setFechaVinculacion(convertDateToXMLGregorianCalendar(guardado.getFechaVinculacion()));

        return response;
    }



    private Date toDate(XMLGregorianCalendar calendar) {
        return calendar == null ? null : calendar.toGregorianCalendar().getTime();
    }
    private XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) {
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}