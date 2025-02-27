package com.code.service;

import com.code.repository.ICuentaRepository;

public class BancoService {

    private final ICuentaRepository cuentaRepository;

    public BancoService(ICuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }

    public double consultarSaldo(String numeroCuenta) {
        return this.cuentaRepository.obtenerSaldo(numeroCuenta);
    }

    public boolean transferir(String cuentaOrigen, String cuentaDestino, double monto) {

        double saldoOrigen = this.cuentaRepository.obtenerSaldo(cuentaOrigen);

        if(saldoOrigen >= monto) {
            this.cuentaRepository.actualizarSaldo(cuentaOrigen, saldoOrigen - monto);
            double saldoDestino = this.cuentaRepository.obtenerSaldo(cuentaDestino);
            this.cuentaRepository.actualizarSaldo(cuentaDestino, saldoDestino + monto);
            return true;
        }

        return false;

    }
}