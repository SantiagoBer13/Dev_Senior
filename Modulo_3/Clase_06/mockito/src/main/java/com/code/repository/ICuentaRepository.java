package com.code.repository;

public interface ICuentaRepository {
    double obtenerSaldo(String numeroCuenta);
    void actualizarSaldo(String numeroCuenta, double nuevoSaldo);
}
