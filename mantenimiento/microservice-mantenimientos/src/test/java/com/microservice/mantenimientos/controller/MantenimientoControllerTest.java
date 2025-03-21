package com.microservice.mantenimientos.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class MantenimientoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Configuración inicial si es necesario
    }

    @Test
    public void testGetMantenimiento() throws Exception {
        mockMvc.perform(get("/mantenimientos/1")) // Cambia la URL según tu controlador
               .andExpect(status().isOk());
    }
}