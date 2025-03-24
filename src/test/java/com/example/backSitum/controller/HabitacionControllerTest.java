// package com.example.backSitum.controller;

// import com.example.backSitum.model.Habitacion;
// import com.example.backSitum.service.HabitacionService;
// import com.example.backSitum.errores.NoEncontrado;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.mockito.Mock;
// import org.mockito.InjectMocks;
// import org.mockito.MockitoAnnotations;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import static org.mockito.Mockito.*;
// import static org.junit.jupiter.api.Assertions.*;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;


// public class HabitacionControllerTest {

//     @Mock
//     private HabitacionService habitacionService;

//     @InjectMocks
//     private HabitacionController habitacionController;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testGetHabitaciones() {
//         Habitacion habitacion1 = new Habitacion();
//         Habitacion habitacion2 = new Habitacion();
//         List<Habitacion> habitaciones = Arrays.asList(habitacion1, habitacion2);

//         when(habitacionService.getHabitaciones()).thenReturn(habitaciones);

//         ResponseEntity<List<Habitacion>> response = habitacionController.getHabitaciones();

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(habitaciones, response.getBody());
//     }

//     @Test
//     public void testGetHabitacionById() {
//         Habitacion habitacion = new Habitacion();
//         when(habitacionService.getHabitacionById(1L)).thenReturn(Optional.of(habitacion));

//         ResponseEntity<Optional<Habitacion>> response = habitacionController.getHabitacionById(1L);

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(habitacion, response.getBody().get());
//     }

//     @Test
//     public void testGetHabitacionById_NotFound() {
//         when(habitacionService.getHabitacionById(1L)).thenReturn(Optional.empty());

//         assertThrows(NoEncontrado.class, () -> {
//             habitacionController.getHabitacionById(1L);
//         });
//     }

//     @Test
//     public void testSaveHabitacion() {
//         Habitacion habitacion = new Habitacion();
//         when(habitacionService.saveHabitacion(habitacion)).thenReturn(habitacion);

//         ResponseEntity<Habitacion> response = habitacionController.saveHabitacion(habitacion);

//         assertEquals(HttpStatus.CREATED, response.getStatusCode());
//         assertEquals(habitacion, response.getBody());
//     }

//     @Test
//     public void testDeleteHabitacion() {
//         Habitacion habitacion = new Habitacion();
//         when(habitacionService.getHabitacionById(1L)).thenReturn(Optional.of(habitacion));
//         doNothing().when(habitacionService).deleteHabitacion(1L);

//         ResponseEntity<?> response = habitacionController.deleteHabitacion(1L);

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         verify(habitacionService, times(1)).deleteHabitacion(1L);
//     }

//     @Test
//     public void testDeleteHabitacion_NotFound() {
//         when(habitacionService.getHabitacionById(1L)).thenReturn(Optional.empty());

//         assertThrows(NoEncontrado.class, () -> {
//             habitacionController.deleteHabitacion(1L);
//         });
//     }

//     @Test
//     public void testUpdateHabitacion() {
//         Habitacion habitacion = new Habitacion();
//         when(habitacionService.getHabitacionById(1L)).thenReturn(Optional.of(habitacion));
//         when(habitacionService.updateHabitacion(1L, habitacion)).thenReturn(habitacion);

//         ResponseEntity<Habitacion> response = habitacionController.updateHabitacion(1L, habitacion);

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(habitacion, response.getBody());
//     }

//     @Test
//     public void testUpdateHabitacion_NotFound() {
//         Habitacion habitacion = new Habitacion();
//         when(habitacionService.getHabitacionById(1L)).thenReturn(Optional.empty());

//         assertThrows(NoEncontrado.class, () -> {
//             habitacionController.updateHabitacion(1L, habitacion);
//         });
//     }
// }