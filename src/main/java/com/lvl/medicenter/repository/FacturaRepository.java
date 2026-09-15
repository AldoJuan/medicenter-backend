package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Factura;
import com.lvl.medicenter.repository.projection.CierreCajaProjection;
import com.lvl.medicenter.repository.projection.VentasPorComprobanteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    @Query(value = """
        SELECT TIPO_COMPROBANTE as tipoComprobante,
               COUNT(*) as cantidad,
               SUM(TOTAL) as montoTotal
        FROM MC_FACTURA
        WHERE FECHA_EMISION >= ?1 AND FECHA_EMISION < ?2
        GROUP BY TIPO_COMPROBANTE
        """, nativeQuery = true)
    List<VentasPorComprobanteProjection> ventasPorComprobante(LocalDateTime desde, LocalDateTime hasta);

    @Query(value = """
        SELECT MONEDA as moneda,
               FORMA_PAGO as formaPago,
               MEDIO_PAGO as medioPago,
               COUNT(*) as cantidadComprobantes,
               SUM(TOTAL) as montoTotal
        FROM MC_FACTURA
        WHERE FECHA_EMISION >= ?1 AND FECHA_EMISION < ?2
        GROUP BY MONEDA, FORMA_PAGO, MEDIO_PAGO
        """, nativeQuery = true)
    List<CierreCajaProjection> cierreCaja(LocalDateTime desde, LocalDateTime hasta);
}
