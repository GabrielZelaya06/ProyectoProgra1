/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Primer_Parcial;

/**
 *
 * @author Gabriel
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class Zelaya_Gabriel_ProyectoTienda {
    
        //static int stockAzucar=0;//kg de azucar en inventario
        //static int stockAvena=0;//kg de avena en inventario
        //static int stockTrigo=0;//kg de trigo en inventario
        //static int stockMaiz=0;//kg de maiz en inventario
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        DecimalFormat df = new DecimalFormat("#.00");
        
        double caja_tienda = 0;//dinero en la caja
        int codigoAzucar=1;//numero de codigo del producto
        int codigoAvena=2;//numero de codigo del producto
        int codigoTrigo=3;//numero de codigo del producto
        int codigoMaiz=4;//numero de codigo del producto
        int codigoProd=0;//codigo de producto
        int cantProd=0;//cantidad de producto
        int stockAzucar=0;//kg de azucar en inventario
        int stockAvena=0;//kg de avena en inventario
        int stockTrigo=0;//kg de trigo en inventario
        int stockMaiz=0;//kg de maiz en inventario
        String prodAzucar="Azúcar";//producto azucar
        String prodAvena="Avena";//producto avena
        String prodTrigo="Trigo";//producto trigo
        String prodMaiz="Maíz";//producto maiz
        double precioV_azucar=30;//precio de venta de azucar
        double precioV_avena=25;//precio de venta de avena
        double precioV_trigo=32;//precio de venta de trigo      
        double precioV_maiz=20;//precio de venta de maiz
        double precioCmp_azucar=25;//precio de compra de azucar
        double precioCmp_avena=0;//precio de compra de avena
        double precioCmp_trigo=30;//precio de compra de trigo 
        double precioCmp_maiz=18;//precio de compra de maiz      
        String otroProd="";//otro producto (para la parte de agregar otro producto)     
        String tipoCliente="";//tipo de cliente
        String tipoProveedor="";//tipo de proveedor
        boolean cajaAbierta = false;//para verificar si la caja fue abierta
        
        System.out.println("****BIENVENIDO****");
        System.out.println("Menú:");
        System.out.println("1. Abrir Caja");
        System.out.println("2. Ventas");
        System.out.println("3. Compras");
        System.out.println("4. Reportes");
        System.out.println("5. Cierre de Caja");
        System.out.println("6. Salir del Sistema");
        System.out.print("Elige una opción:");
        
        int opcion = input.nextInt();
       
        
        while(opcion!=6){
         
        if(opcion>6 || opcion<1){
            
            System.out.println("Opción invalida");
        }
        
        if(opcion==1){
            
            double efectivoInicial=0;
            
            System.out.println("Opción Seleccionada: Abrir Caja");
            System.out.print("Ingrese cantidad de efectivo que desea guardar: ");
            efectivoInicial = input.nextDouble();
            
            if(efectivoInicial<0){
                
            do{
            
                System.out.println("No se permite ingresar una cantidad negativa.");
                System.out.print("Ingrese cantidad de efectivo que desea guardar: ");
                efectivoInicial = input.nextDouble();
            
            }while(efectivoInicial<0);
            
            }
            
            caja_tienda = caja_tienda + efectivoInicial;
            cajaAbierta = true;
            System.out.println("Efectivo en caja: Lps."+df.format(caja_tienda));
        }
        
        
        
        
        
        
        
        if(opcion==2){
            
            if(!cajaAbierta){
                System.out.println("Opción no válida. Tienes que abrir caja primero.");
            }else{
            
            System.out.println("Opción Seleccionada: Ventas");
            
            do{
            System.out.print("Seleccione el Tipo de cliente (A, B o C): ");
            tipoCliente = input.next();
            
            if(!tipoCliente.equalsIgnoreCase("a") && !tipoCliente.equalsIgnoreCase("b") && !tipoCliente.equalsIgnoreCase("c")){
                
                System.out.println("Opción invalida");
            }
            
            }while(!tipoCliente.equalsIgnoreCase("a") && !tipoCliente.equalsIgnoreCase("b") && !tipoCliente.equalsIgnoreCase("c"));
            
            
            
            //CLIENTE TIPO A
            if(tipoCliente.equalsIgnoreCase("a")){
                
                double subtotal =0;
                String contenidoFactura ="";
                
                do{
                    System.out.println("____________________________________________________");
                    System.out.println("|   Código   |    Producto    |     Precio x kg    |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      1     |     Azúcar     |       Lps.30       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      2     |     Avena      |       Lps.25       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      3     |     Trigo      |       Lps.32       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      4     |     Maíz       |       Lps.20       |");
                
                do{
                
                System.out.println("");
                System.out.print("Ingrese código del producto: ");
                codigoProd = input.nextInt();
                        
                if(codigoProd<1 || codigoProd>4){
                    
                    System.out.println("Código invalido");
                }
                
                }while(codigoProd<1 || codigoProd>4);
                
                               
                do{
                System.out.print("Ingrese cantidad de producto(kg): ");
                cantProd = input.nextInt();
                
                if(cantProd<0){
                   
                    System.out.println("Cantidad invalida");
                }
                
                }while(cantProd<0);
               
               
                switch(codigoProd){
                    
                    case 1:
                        if(cantProd<=stockAzucar){
                        subtotal += cantProd*precioV_azucar;
                        contenidoFactura += prodAzucar+"          "+cantProd+" kg       Lps."+precioV_azucar+"           Lps."+(cantProd*precioV_azucar)+"\n";
                        stockAzucar -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                    case 2:
                        if(cantProd<=stockAvena){
                        subtotal += cantProd*precioV_avena;
                        contenidoFactura += prodAvena+"           "+cantProd+" kg       Lps."+precioV_avena+"           Lps."+(cantProd*precioV_avena)+"\n";
                        stockAvena -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                    case 3:
                        if(cantProd<=stockTrigo){
                        subtotal += cantProd*precioV_trigo;
                        contenidoFactura += prodTrigo+"           "+cantProd+" kg       Lps."+precioV_trigo+"           Lps."+(cantProd*precioV_trigo)+"\n";
                        stockTrigo -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                    case 4:
                        if(cantProd<=stockMaiz){
                        subtotal += cantProd*precioV_maiz;
                        contenidoFactura += prodMaiz+"            "+cantProd+" kg       Lps."+precioV_maiz+"           Lps."+(cantProd*precioV_maiz)+"\n";
                        stockMaiz -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                }
                
                do{
                System.out.print("Desea comprar otro producto? (Ingresar si o no): ");
                otroProd = input.next();
                
                if(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no")){
                    
                    System.out.println("Respuesta invalida");
                }
                
                }while(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no"));
                  
                
                }while(otroProd.equalsIgnoreCase("si"));
                
                double descuento= 0;
                
                if(subtotal<=5000 && subtotal>=1000){
                    
                    descuento=subtotal*0.05;
                    
                }else if(subtotal>5000){
                    
                    descuento=subtotal*0.10;
                }
                
                double impuesto=subtotal*0.07;
                double totalPagar=subtotal-descuento+impuesto;
                
                caja_tienda += totalPagar;//Aumenta dinero a la caja
                
                
                if(subtotal>0){
                System.out.println("");
                System.out.println("-----------------------------------------------------------");
                System.out.println("                     FACTURA DE COMPRA                     ");
                System.out.println("-----------------------------------------------------------");
                System.out.println("Producto          Kg    |      P.Unidad      |    Total    ");
                System.out.println("-----------------------------------------------------------");
                System.out.println(contenidoFactura);
                System.out.println("-----------------------------------------------------------");
                System.out.println("Subtotal:                                       Lps."+df.format(subtotal));
                System.out.println("Descuento aplicado:                             Lps."+df.format(descuento));
                System.out.println("Impuesto (7%):                                  Lps."+df.format(impuesto));
                System.out.println("-----------------------------------------------------------");
                System.out.println("TOTAL A PAGAR:                                  Lps."+df.format(totalPagar));
                System.out.println("-----------------------------------------------------------");
                System.out.println("                   GRACIAS POR SU COMPRA                   ");
                System.out.println("-----------------------------------------------------------");
                }

                
            }//CLIENTE TIPO A (cierre)
            
            
            
            //CLIENTE TIPO B
            if(tipoCliente.equalsIgnoreCase("b")){
                
                double subtotal =0;
                String contenidoFactura ="";
                
                do{
                    System.out.println("____________________________________________________");
                    System.out.println("|   Código   |    Producto    |     Precio x kg    |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      1     |     Azúcar     |       Lps.30       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      2     |     Avena      |       Lps.25       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      3     |     Trigo      |       Lps.32       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      4     |     Maíz       |       Lps.20       |");
                    
                    System.out.println("");
                    System.out.print("Ingrese código del producto: ");
                    codigoProd = input.nextInt();
                
                if(codigoProd<1 || codigoProd>4){
                    
                do{
                    
                    System.out.println("Código invalido");
                    System.out.println("");
                    System.out.print("Ingrese código del producto: ");
                    codigoProd = input.nextInt();
                    
                }while(codigoProd<1 || codigoProd>4);
                
                }
                
                if(codigoProd==4){
                    
                    System.out.println("Al ser cliente tipo B, solo puede comprar los productos con código 1, 2 y 3.");
                
                do{
                
                    System.out.print("Desea comprar otro producto? (Ingresar si o no): ");
                    otroProd = input.next();
                
                if(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no")){
                    
                    System.out.println("Respuesta invalida");
                }
                
                }while(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no"));
                
                }
                
                if(codigoProd<4 && codigoProd>0 && codigoProd!=4){
                 
                do{
                
                    System.out.print("Ingrese cantidad de producto(kg): ");
                    cantProd = input.nextInt();
                
                if(cantProd<0){
                   
                    System.out.println("Cantidad invalida");
                }
                
                }while(cantProd<0);
                
                
                
                switch(codigoProd){
                    
                    case 1:
                        if(cantProd<=stockAzucar){
                        subtotal += cantProd*precioV_azucar;
                        contenidoFactura += prodAzucar+"          "+cantProd+" kg       Lps."+precioV_azucar+"           Lps."+(cantProd*precioV_azucar)+"\n";
                        stockAzucar -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                    case 2:
                        if(cantProd<=stockAvena){
                        subtotal += cantProd*precioV_avena;
                        contenidoFactura += prodAvena+"           "+cantProd+" kg       Lps."+precioV_avena+"           Lps."+(cantProd*precioV_avena)+"\n";
                        stockAvena -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                    case 3:
                        if(cantProd<=stockTrigo){
                        subtotal += cantProd*precioV_trigo;
                        contenidoFactura += prodTrigo+"           "+cantProd+" kg       Lps."+precioV_trigo+"           Lps."+(cantProd*precioV_trigo)+"\n";
                        stockTrigo -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                }
                
                
                do{
                    
                    System.out.print("Desea comprar otro producto? (Ingresar si o no): ");
                    otroProd = input.next();
                
                if(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no")){
                    
                    System.out.println("Respuesta invalida");
                }
                
                }while(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no"));   
                
                }
                    
                }while(otroProd.equalsIgnoreCase("si"));
                
                
                double descuento= 0;
                
                if(subtotal<=5000 && subtotal>=1000){
                    
                    descuento=subtotal*0.05;
                    
                }else if(subtotal>5000){
                    
                    descuento=subtotal*0.10;
                }
                
                double impuesto=subtotal*0.07;
                double totalPagar=subtotal-descuento+impuesto;
                
                caja_tienda += totalPagar;//Aumenta dinero a la caja
                
                if(subtotal>0){
                System.out.println("");
                System.out.println("-----------------------------------------------------------");
                System.out.println("                     FACTURA DE COMPRA                     ");
                System.out.println("-----------------------------------------------------------");
                System.out.println("Producto          Kg    |      P.Unidad      |    Total    ");
                System.out.println("-----------------------------------------------------------");
                System.out.println(contenidoFactura);
                System.out.println("-----------------------------------------------------------");
                System.out.println("Subtotal:                                       Lps."+df.format(subtotal));
                System.out.println("Descuento aplicado:                             Lps."+df.format(descuento));
                System.out.println("Impuesto (7%):                                  Lps."+df.format(impuesto));
                System.out.println("-----------------------------------------------------------");
                System.out.println("TOTAL A PAGAR:                                  Lps."+df.format(totalPagar));
                System.out.println("-----------------------------------------------------------");
                System.out.println("                   GRACIAS POR SU COMPRA                   ");
                System.out.println("-----------------------------------------------------------");
                }
                
            }//CLIENTE TIPO B (cierre)
            
            
            //CLIENTE TIPO C
            if(tipoCliente.equalsIgnoreCase("c")){
                
                double subtotal =0;
                String contenidoFactura ="";
                
                do{
                    System.out.println("____________________________________________________");
                    System.out.println("|   Código   |    Producto    |     Precio x kg    |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      1     |     Azúcar     |       Lps.30       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      2     |     Avena      |       Lps.25       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      3     |     Trigo      |       Lps.32       |");
                    System.out.println("|------------|----------------|--------------------|");
                    System.out.println("|      4     |     Maíz       |       Lps.20       |");
                    
                    System.out.println("");
                    System.out.print("Ingrese código del producto: ");
                    codigoProd = input.nextInt();  
                
                if(codigoProd<1 || codigoProd>4){
                    
                do{
                    
                    System.out.println("Código invalido");
                    System.out.println("");
                    System.out.print("Ingrese código del producto: ");
                    codigoProd = input.nextInt();
                    
                }while(codigoProd<1 || codigoProd>4);
                
                }//IF codigoProd<1 || codigoProd>4
                
                if(codigoProd>0 && codigoProd<4){
                    
                    System.out.println("Al ser cliente tipo C, solo puede comprar los productos con código 4.");
                
                do{
                
                    System.out.print("Desea comprar otro producto? (Ingresar si o no): ");
                    otroProd = input.next();
                
                if(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no")){
                    
                    System.out.println("Respuesta invalida");
                }
                
                }while(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no"));
                
                }
                
                if(codigoProd==4){
                
                do{
                
                    System.out.print("Ingrese cantidad de producto(kg): ");
                    cantProd = input.nextInt();
                
                    if(cantProd<0){
                   
                    System.out.println("Cantidad invalida");
                    
                    }
                
                }while(cantProd<0);
                
                
                switch(codigoProd){
                    
                    case 4:
                        if(cantProd<=stockMaiz){
                        subtotal += cantProd*precioV_maiz;
                        contenidoFactura += prodMaiz+"            "+cantProd+" kg       Lps."+precioV_maiz+"           Lps."+(cantProd*precioV_maiz)+"\n";
                        stockMaiz -= cantProd;
                        }else{
                            System.out.println("No hay suficiente stock");
                        }
                        break;
                }
                
                
                do{
                    
                    System.out.print("Desea comprar otro producto? (Ingresar si o no): ");
                    otroProd = input.next();
                
                if(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no")){
                    
                    System.out.println("Respuesta invalida");
                }
                
                }while(!otroProd.equalsIgnoreCase("si") && !otroProd.equalsIgnoreCase("no"));
                
                }
                
                
                }while(otroProd.equalsIgnoreCase("si"));
                
                
                double descuento= 0;
                
                if(subtotal<=5000 && subtotal>=1000){
                    
                    descuento=subtotal*0.05;
                    
                }else if(subtotal>5000){
                    
                    descuento=subtotal*0.10;
                }
                
                double impuesto=subtotal*0.07;
                double totalPagar=subtotal-descuento+impuesto;
                
                caja_tienda += totalPagar;//Aumenta dinero a la caja
                
                if(subtotal>0){
                System.out.println("");
                System.out.println("-----------------------------------------------------------");
                System.out.println("                     FACTURA DE COMPRA                     ");
                System.out.println("-----------------------------------------------------------");
                System.out.println("Producto          Kg    |      P.Unidad      |    Total    ");
                System.out.println("-----------------------------------------------------------");
                System.out.println(contenidoFactura);
                System.out.println("-----------------------------------------------------------");
                System.out.println("Subtotal:                                       Lps."+df.format(subtotal));
                System.out.println("Descuento aplicado:                             Lps."+df.format(descuento));
                System.out.println("Impuesto (7%):                                  Lps."+df.format(impuesto));
                System.out.println("-----------------------------------------------------------");
                System.out.println("TOTAL A PAGAR:                                  Lps."+df.format(totalPagar));
                System.out.println("-----------------------------------------------------------");
                System.out.println("                   GRACIAS POR SU COMPRA                   ");
                System.out.println("-----------------------------------------------------------");
                }
               
            }//CLIENTE TIPO C (cierre)
            
               
            
            }//IF CAJA ABIERTA
            
        }//IF OPCION 2
        
        
        
        
        
        
        
        
        
        
        if(opcion==3){
            
            if(!cajaAbierta){
                System.out.println("Opción no válida. Tienes que abrir caja primero.");
            }else{
            
            System.out.println("Opción Seleccionada: Compras");
            
            do{
            System.out.print("Seleccione el Tipo de Proveedor (A, B o C): ");
            tipoProveedor = input.next();
            
            if(!tipoProveedor.equalsIgnoreCase("a") && !tipoProveedor.equalsIgnoreCase("b") && !tipoProveedor.equalsIgnoreCase("c")){
                
                System.out.println("Opción invalida");
            }
            
            }while(!tipoProveedor.equalsIgnoreCase("a") && !tipoProveedor.equalsIgnoreCase("b") && !tipoProveedor.equalsIgnoreCase("c"));
            
            
            //PROVEEDOR TIPO A
            if(tipoProveedor.equalsIgnoreCase("a")){
                
                    double subtotal=0;
                    String detallesCompra="";
               
                    System.out.println("_______________________________________________________");
                    System.out.println("|   Código   |    Producto    |      Precio x kg      |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      1     |     Azúcar     |         Lps.25        |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      2     |     Avena      | (B)Lps.20 | (C)Lps.22 |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      3     |     Trigo      |         Lps.30        |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      4     |     Maíz       |         Lps.18        |");
                    
                    System.out.println("");
                    System.out.println("(B)= Precio del proveedor tipo B");
                    System.out.println("(C)= Precio del proveedor tipo C");
                    
                    System.out.println("");
                    System.out.print("Ingrese código del producto: ");
                    codigoProd = input.nextInt();
                    
                if(codigoProd==2 || codigoProd==3){
                  
                    System.out.println("Proveedor no vende dicho producto.");
                                           
                }else if(codigoProd<1 || codigoProd>4){
                        
                    System.out.println("Código invalido");
                    
                }else if(codigoProd==1 || codigoProd==4){
                    
                    do{
                        System.out.print("Ingrese cantidad de producto(kg): ");
                        cantProd = input.nextInt();
                        
                        if(cantProd<=0){
                            
                            System.out.println("Cantidad invalida");
                        }
                        
                    }while(cantProd<=0);
                    
                    switch(codigoProd){
                    
                    case 1:
                        subtotal += cantProd*precioCmp_azucar;
                        detallesCompra += prodAzucar+"          "+cantProd+" kg         Lps."+precioCmp_azucar+"             Lps."+(cantProd*precioCmp_azucar)+"\n";
                        break;
                  
                    case 4:
                        subtotal += cantProd*precioCmp_maiz;
                        detallesCompra += prodMaiz+"            "+cantProd+" kg         Lps."+precioCmp_maiz+"             Lps."+(cantProd*precioCmp_maiz)+"\n";
                        break;
                    }
                    
                    
                    double totalPagar=subtotal;
                    
                    if(totalPagar>caja_tienda){
                        
                        System.out.println("No se puede pagar compra");
                       
                    }else if(totalPagar<=caja_tienda){
                        
                    caja_tienda -= totalPagar;//Resta dinero a la caja
                
                     
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("                     FACTURA DE COMPRA                     ");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Producto          Kg    |      P.Unidad      |    Total    ");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println(detallesCompra);
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Subtotal:                                       Lps."+df.format(subtotal));
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("TOTAL A PAGAR:                                  Lps."+df.format(totalPagar));
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("                   GRACIAS POR SU COMPRA                   ");
                        System.out.println("-----------------------------------------------------------");
                        
                        if(codigoProd==1){
                            
                            stockAzucar += cantProd;
                            System.out.println("Stock actual de Azúcar: "+stockAzucar);
                            
                        }else if(codigoProd==4){
                            
                            stockMaiz += cantProd;
                            System.out.println("Stock actual de Maíz: "+stockMaiz);
                            
                        }
                    }
                }   
                    
            }//PROVEEDOR TIPO A (cierre)
            
            
            //PROVEEDOR TIPO B
            if(tipoProveedor.equalsIgnoreCase("b")){
                
                    double subtotal=0;
                    String detallesCompra="";
                    precioCmp_avena=20;
               
                    System.out.println("_______________________________________________________");
                    System.out.println("|   Código   |    Producto    |      Precio x kg      |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      1     |     Azúcar     |         Lps.25        |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      2     |     Avena      | (B)Lps.20 | (C)Lps.22 |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      3     |     Trigo      |         Lps.30        |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      4     |     Maíz       |         Lps.18        |");
                    
                    System.out.println("");
                    System.out.println("(B)= Precio del proveedor tipo B");
                    System.out.println("(C)= Precio del proveedor tipo C");
                    
                    System.out.println("");
                    System.out.print("Ingrese código del producto: ");
                    codigoProd = input.nextInt();
                    
                if(codigoProd==1 || codigoProd==4){
                  
                    System.out.println("Proveedor no vende dicho producto.");
                                           
                }else if(codigoProd<1 || codigoProd>4){
                        
                    System.out.println("Código invalido");
                    
                }else if(codigoProd==2 || codigoProd==3){
                    
                    do{
                        System.out.print("Ingrese cantidad de producto(kg): ");
                        cantProd = input.nextInt();
                        
                        if(cantProd<=0){
                            
                            System.out.println("Cantidad invalida");
                        }
                        
                    }while(cantProd<=0);
                    
                    switch(codigoProd){
                    
                    case 2:
                        subtotal += cantProd*precioCmp_avena;
                        detallesCompra += prodAvena+"          "+cantProd+" kg         Lps."+precioCmp_avena+"             Lps."+(cantProd*precioCmp_avena)+"\n";
                        break;
                  
                    case 3:
                        subtotal += cantProd*precioCmp_trigo;
                        detallesCompra += prodTrigo+"            "+cantProd+" kg         Lps."+precioCmp_trigo+"             Lps."+(cantProd*precioCmp_trigo)+"\n";
                        break;
                    }
                    
                    
                    double totalPagar=subtotal;
                    
                    if(totalPagar>caja_tienda){
                        
                        System.out.println("No se puede pagar compra");
                       
                    }else if(totalPagar<=caja_tienda){
                        
                    caja_tienda -= totalPagar;//Resta dinero a la caja
                
                     
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("                     FACTURA DE COMPRA                     ");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Producto          Kg    |      P.Unidad      |    Total    ");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println(detallesCompra);
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Subtotal:                                       Lps."+df.format(subtotal));
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("TOTAL A PAGAR:                                  Lps."+df.format(totalPagar));
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("                   GRACIAS POR SU COMPRA                   ");
                        System.out.println("-----------------------------------------------------------");
                        
                        if(codigoProd==2){
                            
                            stockAvena += cantProd;
                            System.out.println("Stock actual de Avena: "+stockAvena);
                            
                        }else if(codigoProd==3){
                            
                            stockTrigo += cantProd;
                            System.out.println("Stock actual de Trigo: "+stockTrigo);
                            
                        }
                        
                      } 
                        
                    }

                       
                    
            }//PROVEEDOR TIPO B (cierre)
            
            
            //PROVEEDOR TIPO C
            if(tipoProveedor.equalsIgnoreCase("c")){
                
                    double subtotal=0;
                    String detallesCompra="";
                    precioCmp_avena=22;
               
                    System.out.println("_______________________________________________________");
                    System.out.println("|   Código   |    Producto    |      Precio x kg      |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      1     |     Azúcar     |         Lps.25        |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      2     |     Avena      | (B)Lps.20 | (C)Lps.22 |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      3     |     Trigo      |         Lps.30        |");
                    System.out.println("|------------|----------------|-----------------------|");
                    System.out.println("|      4     |     Maíz       |         Lps.18        |");
                    
                    System.out.println("");
                    System.out.println("(B)= Precio del proveedor tipo B");
                    System.out.println("(C)= Precio del proveedor tipo C");
                    
                    System.out.println("");
                    System.out.print("Ingrese código del producto: ");
                    codigoProd = input.nextInt();
                    
                if(codigoProd==1 || codigoProd==3 || codigoProd==4){
                  
                    System.out.println("Proveedor no vende dicho producto.");
                                           
                }else if(codigoProd<1 || codigoProd>4){
                        
                    System.out.println("Código invalido");
                    
                }else if(codigoProd==2){
                    
                    do{
                        System.out.print("Ingrese cantidad de producto(kg): ");
                        cantProd = input.nextInt();
                        
                        if(cantProd<=0){
                            
                            System.out.println("Cantidad invalida");
                        }
                        
                    }while(cantProd<=0);
                    
                    switch(codigoProd){
                    
                    case 2:
                        subtotal += cantProd*precioCmp_avena;
                        detallesCompra += prodAvena+"          "+cantProd+" kg         Lps."+precioCmp_avena+"             Lps."+(cantProd*precioCmp_avena)+"\n";
                        break;
                    }
                    
                    
                    double totalPagar=subtotal;
                    
                    if(totalPagar>caja_tienda){
                        
                        System.out.println("No se puede pagar compra");
                       
                    }else if(totalPagar<=caja_tienda){
                        
                    caja_tienda -= totalPagar;//Resta dinero a la caja
                
                     
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("                     FACTURA DE COMPRA                     ");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Producto          Kg    |      P.Unidad      |    Total    ");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println(detallesCompra);
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Subtotal:                                       Lps."+df.format(subtotal));
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("TOTAL A PAGAR:                                  Lps."+df.format(totalPagar));
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("                   GRACIAS POR SU COMPRA                   ");
                        System.out.println("-----------------------------------------------------------");
                        
                        stockAvena += cantProd;
                        System.out.println("Stock actual de Avena: "+stockAvena);
                        
                    }
                    
                    
                }   
                    
            }//PROVEEDOR TIPO C (cierre)
            
            
            }
                   
                     
        }//IF OPCION 3
        
        
        
        
        
        
        
        
        
        if(opcion==4){
            
            // a. Cantidad actual en caja al momento de cierre
            
            // b. Numero de compras y ventas realizadas al dia
            
            // c. Volumen total de compras y ventas efectuadas antes del cierre. Mostrando el margen de ganancia obtenido tambien
            
            // d. Valor medio de compra y venta (PROMEDIO)
            
            
            
            
            
        }
        
        
        
         
        System.out.println("");
        System.out.println("Menú:");
        System.out.println("1. Abrir Caja");
        System.out.println("2. Ventas");
        System.out.println("3. Compras");
        System.out.println("4. Reportes");
        System.out.println("5. Cierre de Caja");
        System.out.println("6. Salir del Sistema");
        System.out.print("Elige una opción:");
        
        opcion = input.nextInt();
        
      }//WHILE OPCION!=6
        
    }//MAIN
    
}//PUBLIC CLASS

/*

Hacer que cuando se abra y cierre caja cambie de dia
No permitir menos de 0 lps en caja

Permitir doubles en cantidad de producto

Agregar comentarios
*/


/* COMPLETADO:

-Que no se realizen ventas si la caja no se ha abierto
-Que no se imprima factura si no hay compra
-No permitir la compra si no hay suficiente dinero en caja
-No permitir ventas si no hay suficiente stock
-Hacer que sume el stock por cada compra que yo haga
*/