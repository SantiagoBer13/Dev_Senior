package com.code;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.repository.ICuentaRepository;
import com.code.service.BancoService;

public class BancoServiceTest {
    
    private BancoService bancoService;
    private ICuentaRepository mockCuentaRepository;

    @BeforeEach
    void setup(){
        this.mockCuentaRepository = mock(ICuentaRepository.class);
        this.bancoService = new BancoService(mockCuentaRepository);
    }

    @Test
    void testConsultarSaldo(){
        when(this.mockCuentaRepository.obtenerSaldo("123")).thenReturn(250000.0);
        assertEquals(250000.0, this.bancoService.consultarSaldo("123"));
    }

    @Test
    void testTransferir(){
        // Given
        when(this.mockCuentaRepository.obtenerSaldo("123")).thenReturn(1000.0);
        when(this.mockCuentaRepository.obtenerSaldo("456")).thenReturn(500.0);

        // When
        boolean resultado = bancoService.transferir("123", "456", 200.0);

        // Then
        assertTrue(resultado);
        verify(this.mockCuentaRepository).actualizarSaldo("123", 800.0);
        verify(this.mockCuentaRepository).actualizarSaldo("456", 700.0);
    }

    @Test
    void testTransferenciaFallida(){
        // Given
        when(this.mockCuentaRepository.obtenerSaldo("123")).thenReturn(1000.0);
        when(this.mockCuentaRepository.obtenerSaldo("456")).thenReturn(500.0);

        // When
        boolean resultado = bancoService.transferir("123", "456", 2000.0);

        // Then
        assertFalse(resultado);
        // verify(this.mockCuentaRepository).actualizarSaldo("123", 800.0);
        // verify(this.mockCuentaRepository).actualizarSaldo("456", 700.0);
    }
}
