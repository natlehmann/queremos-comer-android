package org.lehmann.natalia.queremoscomer;

import org.junit.Test;
import org.lehmann.natalia.queremoscomer.servicios.MenuService;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class MenuServiceTest {
    @Test
    public void getTiempoHastaProximoAvisoAlmuerzo() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        long resultado = MenuService.getTiempoHastaProximoAviso(cal.getTime());

        assertEquals(MenuService.HORA_NOTIF_ALMUERZO * 60 * 60 * 1000, resultado);
    }

    @Test
    public void getTiempoHastaProximoAvisoAlmuerzo2() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, MenuService.HORA_NOTIF_ALMUERZO - 2);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        long resultado = MenuService.getTiempoHastaProximoAviso(cal.getTime());

        assertEquals(2 * 60 * 60 * 1000, resultado);
    }

    @Test
    public void getTiempoHastaProximoAvisoCena() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, MenuService.HORA_NOTIF_ALMUERZO + 2);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        long resultado = MenuService.getTiempoHastaProximoAviso(cal.getTime());

        assertEquals((MenuService.HORA_NOTIF_CENA - (MenuService.HORA_NOTIF_ALMUERZO + 2))
                * 60 * 60 * 1000, resultado);
    }

    @Test
    public void getTiempoHastaProximoAvisoCenaEnPunto() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, MenuService.HORA_NOTIF_CENA);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        long resultado = MenuService.getTiempoHastaProximoAviso(cal.getTime());

        assertEquals((24 - MenuService.HORA_NOTIF_CENA + MenuService.HORA_NOTIF_ALMUERZO)
                * 60 * 60 * 1000, resultado);
    }

    @Test
    public void getTiempoHastaProximoAvisoPasandoLaCena() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, MenuService.HORA_NOTIF_CENA + 3);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        long resultado = MenuService.getTiempoHastaProximoAviso(cal.getTime());

        assertEquals((24 - MenuService.HORA_NOTIF_CENA - 3 + MenuService.HORA_NOTIF_ALMUERZO)
                * 60 * 60 * 1000, resultado);
    }
}