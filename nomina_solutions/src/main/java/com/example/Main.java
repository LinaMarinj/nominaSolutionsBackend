package com.example;

import java.util.Scanner;

public class Main {

    public static String[] arregloEmpleados = new String[100];
    public static int empleadosActivos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvendio a Nomina Solutions");
        int option;
        do {
            System.out.println("1. Administrador");
            System.out.println("2. Empleado");
            System.out.println("0. Salir");
            System.out.print("Selecciona tu perfil: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    option = menuAdministrador(scanner);
                    break;
                case 2:
                    liquidarEmpleado(scanner);
                    break;
                case 9:
                    option = 9;
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            System.out.println();
        } while (option != 0);
    }

    private static int menuAdministrador(Scanner scanner) {
        System.out.println("Bienvenido Administrador");
        int option;

        do {
            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Crear empleado");
            System.out.println("2. Liquidar Empleado");
            System.out.println("3. Ver Empleados");
            System.out.println("9. Voler al menu principal");
            System.out.println("0. Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    crearEmpleado(scanner);
                    break;
                case 2:
                    liquidarEmpleado(scanner);
                    break;
                case 3:
                    verEmpleados();
                    break;
                case 9:
                    System.out.println("Volviendo al menu principal");
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            System.out.println();
        } while (option != 0 && option != 9);

        return option;
    }

    private static void crearEmpleado(Scanner scanner) {
        String[] arregloInformacionEmpleado = new String[8];

        System.out.println("¡Ingresa la información del empleado!");

        System.out.println("Ingresa la ceédula del empleado:");
        int cedula = scanner.nextInt();
        arregloInformacionEmpleado[0] = String.valueOf(cedula);

        System.out.print("Ingresa el nombre del empleado: ");
        String nombre = scanner.next();
        arregloInformacionEmpleado[1] = nombre;

        System.out.print("Ingresa el primer apellido del empleado: ");
        String primerApellido = scanner.next();
        arregloInformacionEmpleado[2] = primerApellido;

        System.out.print("Ingresa el segundo apellido del empleado: ");
        String segundoApellido = scanner.next();
        arregloInformacionEmpleado[3] = segundoApellido;

        System.out.print("Ingresa el cargo del empleado: ");
        String cargo = scanner.next();
        arregloInformacionEmpleado[4] = cargo;

        System.out.print("Ingresa el correo electrónico del empleado: ");
        String correoElectronico = scanner.next();
        arregloInformacionEmpleado[5] = correoElectronico;

        System.out.print("Ingresa el teléfono del empleado: ");
        String telefono = scanner.next();
        arregloInformacionEmpleado[6] = telefono;

        System.out.print("Ingresa el salario total del mes del empleado: ");
        double salarioTotal = scanner.nextDouble();
        arregloInformacionEmpleado[7] = String.valueOf(salarioTotal);

        arregloEmpleados[empleadosActivos] = String.join(",", arregloInformacionEmpleado);
        empleadosActivos++;

        System.out.println("¡Empleado creado!");
    }

    private static void liquidarEmpleado(Scanner scanner) {
        System.out.println("¡Ingresa los datos para liquidar!");

        System.out.print("Salario mensual: ");
        double salarioMensual = scanner.nextDouble();

        System.out.print("Dias trabajados: ");
        int diasTrabajados = scanner.nextInt();

        System.out.print("Valor auxilio de transporte: ");
        double auxilioTransporte = scanner.nextDouble();

        System.out.print("Días de vacaciones restantes: ");
        int diasVacaciones = scanner.nextInt();

        double salarioDiario = salarioMensual / 30;

        double salarioPorDiasTrabajados = salarioDiario * diasTrabajados;

        double valorVacaciones = (salarioDiario + auxilioTransporte / 30) * diasVacaciones;

        double primaServicios = salarioMensual * diasTrabajados / 365;

        double totalLiquidacion = salarioPorDiasTrabajados + valorVacaciones + primaServicios;

        System.out.println("Total Liquidación: " + totalLiquidacion);
    }

    private static void verEmpleados() {
        System.out.println("Total empleados: " + empleadosActivos);
        for (String empleado : arregloEmpleados) {
            if (empleado != null) {
                String[] informacionEmpleado = empleado.split(",");
                System.out.println("Cedula: " + informacionEmpleado[0]);
                System.out.println("Nombre: " + informacionEmpleado[1]);
                System.out.println("Primer Apellido: " + informacionEmpleado[2]);
                System.out.println("Segundo Apellido: " + informacionEmpleado[3]);
                System.out.println("Cargo: " + informacionEmpleado[4]);
                System.out.println("Correo Electrónico: " + informacionEmpleado[5]);
                System.out.println("Teléfono: " + informacionEmpleado[6]);
                System.out.println("Salario Total: " + informacionEmpleado[7]);
                System.out.println("-------------------------------");
            }
        }
    }
}