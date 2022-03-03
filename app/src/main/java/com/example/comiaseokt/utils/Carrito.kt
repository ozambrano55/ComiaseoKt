package com.example.comiaseokt.utils

import com.example.comiaseokt.entity.DetallePedido

public class Carrito {
    //Creamos un arrayList de la clase detallePedido
    private val detallePedidos: ArrayList<DetallePedido> = ArrayList<DetallePedido>()

    //Método para agregar productos al carrito(bolsa)
    fun agregarPlatillos(detallePedido: DetallePedido): String? {
        var index = 0
        var b = false
        for (dp in detallePedidos) {
           /* if (dp.getPlatillo().getId() === detallePedido.getPlatillo().getId()) {
                detallePedidos[index] = detallePedido
                b = true
                return "El platillo ha sido agregado al carrito, se actualizará la cantidad"
            }*/
            index++
        }
        if (!b) {
            detallePedidos.add(detallePedido)
            return "El platillo ha sido agregado al carrito con éxito"
        }
        return ". . . . "
    }

    //Método para eliminar un platillo del carrito(bolsa)
    fun eliminar(idp: Int) {
        var dpE: DetallePedido? = null
        for (dp in detallePedidos) {
            /*if (dp.getPlatillo().getId() === idp) {
                dpE = dp
                break
            }*/
        }
        if (dpE != null) {
            detallePedidos.remove(dpE)
            println("Se elimino el platillo del detalle de pedido")
        }
    }

    //Método para conseguir los detalles del pedido
    fun getDetallePedidos(): ArrayList<DetallePedido>? {
        return detallePedidos
    }

    //Método para limpiar
    fun limpiar() {
        detallePedidos.clear()
    }
}