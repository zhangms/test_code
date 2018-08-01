package com.jtemp.test.demo;

public class OutOfMemoryDemo {

    public static void main(String[] args) {

        OutOfMemoryDemo demo = new OutOfMemoryDemo();
//        demo.demo();

        String str = new String( new byte[]{
                0x49, 0x20, 0x77, 0x69, 0x6c, 0x6c, 0x20, 0x6e, 0x6f, 0x74, 0x20, 0x6d, 0x61, 0x6b, 0x65, 0x20, 0x74, 0x68, 0x65,
                0x20, 0x73, 0x61, 0x6d, 0x65, 0x20, 0x6d, 0x69, 0x73, 0x74, 0x61, 0x6b, 0x65, 0x73, 0x20, 0x74, 0x68, 0x61, 0x74,
                0x20, 0x79, 0x6f, 0x75, 0x20, 0x64, 0x69, 0x64, 0x0a, 0x49, 0x20, 0x77, 0x69, 0x6c, 0x6c, 0x20, 0x6e, 0x6f, 0x74,
                0x20, 0x6c, 0x65, 0x74, 0x20, 0x6d, 0x79, 0x73, 0x65, 0x6c, 0x66, 0x0a, 0x43, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6d,
                0x79, 0x20, 0x68, 0x65, 0x61, 0x72, 0x74, 0x20, 0x73, 0x6f, 0x20, 0x6d, 0x75, 0x63, 0x68, 0x20, 0x6d, 0x69, 0x73,
                0x65, 0x72, 0x79, 0x0a, 0x49, 0x20, 0x77, 0x69, 0x6c, 0x6c, 0x20, 0x6e, 0x6f, 0x74, 0x20, 0x62, 0x72, 0x65, 0x61,
                0x6b, 0x20, 0x74, 0x68, 0x65, 0x20, 0x77, 0x61, 0x79, 0x20, 0x79, 0x6f, 0x75, 0x20, 0x64, 0x69, 0x64, 0x0a, 0x59,
                0x6f, 0x75, 0x20, 0x66, 0x65, 0x6c, 0x6c, 0x20, 0x73, 0x6f, 0x20, 0x68, 0x61, 0x72, 0x64, 0x0a, 0x0a, 0x49, 0x20,
                0x76, 0x65, 0x20, 0x6c, 0x65, 0x61, 0x72, 0x6e, 0x65, 0x64, 0x20, 0x74, 0x68, 0x65, 0x20, 0x68, 0x61, 0x72, 0x64,
                0x20, 0x77, 0x61, 0x79, 0x0a, 0x54, 0x6f, 0x20, 0x6e, 0x65, 0x76, 0x65, 0x72, 0x20, 0x6c, 0x65, 0x74, 0x20, 0x69,
                0x74, 0x20, 0x67, 0x65, 0x74, 0x20, 0x74, 0x68, 0x61, 0x74, 0x20, 0x66, 0x61, 0x72, 0x0a, 0x0a, 0x42, 0x65, 0x63,
                0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49, 0x20, 0x6e, 0x65, 0x76, 0x65, 0x72,
                0x20, 0x73, 0x74, 0x72, 0x61, 0x79, 0x20, 0x74, 0x6f, 0x6f, 0x20, 0x66, 0x61, 0x72, 0x20, 0x66, 0x72, 0x6f, 0x6d,
                0x20, 0x74, 0x68, 0x65, 0x20, 0x73, 0x69, 0x64, 0x65, 0x77, 0x61, 0x6c, 0x6b, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75,
                0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49, 0x20, 0x6c, 0x65, 0x61, 0x72, 0x6e, 0x65, 0x64,
                0x20, 0x74, 0x6f, 0x20, 0x70, 0x6c, 0x61, 0x79, 0x20, 0x6f, 0x6e, 0x20, 0x74, 0x68, 0x65, 0x20, 0x73, 0x61, 0x66,
                0x65, 0x20, 0x73, 0x69, 0x64, 0x65, 0x20, 0x73, 0x6f, 0x20, 0x49, 0x20, 0x64, 0x6f, 0x6e, 0x20, 0x74, 0x20, 0x67,
                0x65, 0x74, 0x20, 0x68, 0x75, 0x72, 0x74, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20,
                0x79, 0x6f, 0x75, 0x0a, 0x49, 0x20, 0x66, 0x69, 0x6e, 0x64, 0x20, 0x69, 0x74, 0x20, 0x68, 0x61, 0x72, 0x64, 0x20,
                0x74, 0x6f, 0x20, 0x74, 0x72, 0x75, 0x73, 0x74, 0x20, 0x6e, 0x6f, 0x74, 0x20, 0x6f, 0x6e, 0x6c, 0x79, 0x20, 0x6d,
                0x65, 0x2c, 0x20, 0x62, 0x75, 0x74, 0x20, 0x65, 0x76, 0x65, 0x72, 0x79, 0x6f, 0x6e, 0x65, 0x20, 0x61, 0x72, 0x6f,
                0x75, 0x6e, 0x64, 0x20, 0x6d, 0x65, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79,
                0x6f, 0x75, 0x0a, 0x49, 0x20, 0x61, 0x6d, 0x20, 0x61, 0x66, 0x72, 0x61, 0x69, 0x64, 0x0a, 0x0a, 0x49, 0x20, 0x6c,
                0x6f, 0x73, 0x65, 0x20, 0x6d, 0x79, 0x20, 0x77, 0x61, 0x79, 0x0a, 0x41, 0x6e, 0x64, 0x20, 0x69, 0x74, 0x20, 0x73,
                0x20, 0x6e, 0x6f, 0x74, 0x20, 0x74, 0x6f, 0x6f, 0x20, 0x6c, 0x6f, 0x6e, 0x67, 0x20, 0x62, 0x65, 0x66, 0x6f, 0x72,
                0x65, 0x20, 0x79, 0x6f, 0x75, 0x20, 0x70, 0x6f, 0x69, 0x6e, 0x74, 0x20, 0x69, 0x74, 0x20, 0x6f, 0x75, 0x74, 0x0a,
                0x49, 0x20, 0x63, 0x61, 0x6e, 0x6e, 0x6f, 0x74, 0x20, 0x63, 0x72, 0x79, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73,
                0x65, 0x20, 0x79, 0x6f, 0x75, 0x20, 0x6b, 0x6e, 0x6f, 0x77, 0x20, 0x74, 0x68, 0x61, 0x74, 0x20, 0x73, 0x20, 0x77,
                0x65, 0x61, 0x6b, 0x6e, 0x65, 0x73, 0x73, 0x20, 0x69, 0x6e, 0x20, 0x79, 0x6f, 0x75, 0x72, 0x20, 0x65, 0x79, 0x65,
                0x73, 0x0a, 0x49, 0x20, 0x6d, 0x20, 0x66, 0x6f, 0x72, 0x63, 0x65, 0x64, 0x20, 0x74, 0x6f, 0x20, 0x66, 0x61, 0x6b,
                0x65, 0x0a, 0x41, 0x20, 0x73, 0x6d, 0x69, 0x6c, 0x65, 0x2c, 0x20, 0x61, 0x20, 0x6c, 0x61, 0x75, 0x67, 0x68, 0x20,
                0x65, 0x76, 0x65, 0x72, 0x79, 0x64, 0x61, 0x79, 0x20, 0x6f, 0x66, 0x20, 0x6d, 0x79, 0x20, 0x6c, 0x69, 0x66, 0x65,
                0x0a, 0x4d, 0x79, 0x20, 0x68, 0x65, 0x61, 0x72, 0x74, 0x20, 0x63, 0x61, 0x6e, 0x27, 0x74, 0x20, 0x70, 0x6f, 0x73,
                0x73, 0x69, 0x62, 0x6c, 0x79, 0x20, 0x62, 0x72, 0x65, 0x61, 0x6b, 0x0a, 0x57, 0x68, 0x65, 0x6e, 0x20, 0x69, 0x74,
                0x20, 0x77, 0x61, 0x73, 0x6e, 0x27, 0x74, 0x20, 0x65, 0x76, 0x65, 0x6e, 0x20, 0x77, 0x68, 0x6f, 0x6c, 0x65, 0x20,
                0x74, 0x6f, 0x20, 0x73, 0x74, 0x61, 0x72, 0x74, 0x20, 0x77, 0x69, 0x74, 0x68, 0x0a, 0x0a, 0x42, 0x65, 0x63, 0x61,
                0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49, 0x20, 0x6e, 0x65, 0x76, 0x65, 0x72, 0x20,
                0x73, 0x74, 0x72, 0x61, 0x79, 0x20, 0x74, 0x6f, 0x6f, 0x20, 0x66, 0x61, 0x72, 0x20, 0x66, 0x72, 0x6f, 0x6d, 0x20,
                0x74, 0x68, 0x65, 0x20, 0x73, 0x69, 0x64, 0x65, 0x77, 0x61, 0x6c, 0x6b, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73,
                0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49, 0x20, 0x6c, 0x65, 0x61, 0x72, 0x6e, 0x65, 0x64, 0x20,
                0x74, 0x6f, 0x20, 0x70, 0x6c, 0x61, 0x79, 0x20, 0x6f, 0x6e, 0x20, 0x74, 0x68, 0x65, 0x20, 0x73, 0x61, 0x66, 0x65,
                0x20, 0x73, 0x69, 0x64, 0x65, 0x20, 0x73, 0x6f, 0x20, 0x49, 0x20, 0x64, 0x6f, 0x6e, 0x20, 0x74, 0x20, 0x67, 0x65,
                0x74, 0x20, 0x68, 0x75, 0x72, 0x74, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79,
                0x6f, 0x75, 0x0a, 0x49, 0x20, 0x66, 0x69, 0x6e, 0x64, 0x20, 0x69, 0x74, 0x20, 0x68, 0x61, 0x72, 0x64, 0x20, 0x74,
                0x6f, 0x20, 0x74, 0x72, 0x75, 0x73, 0x74, 0x20, 0x6e, 0x6f, 0x74, 0x20, 0x6f, 0x6e, 0x6c, 0x79, 0x20, 0x6d, 0x65,
                0x2c, 0x20, 0x62, 0x75, 0x74, 0x20, 0x65, 0x76, 0x65, 0x72, 0x79, 0x6f, 0x6e, 0x65, 0x20, 0x61, 0x72, 0x6f, 0x75,
                0x6e, 0x64, 0x20, 0x6d, 0x65, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f,
                0x75, 0x0a, 0x49, 0x20, 0x61, 0x6d, 0x20, 0x61, 0x66, 0x72, 0x61, 0x69, 0x64, 0x0a, 0x0a, 0x49, 0x20, 0x77, 0x61,
                0x74, 0x63, 0x68, 0x65, 0x64, 0x20, 0x79, 0x6f, 0x75, 0x20, 0x64, 0x69, 0x65, 0x0a, 0x49, 0x20, 0x68, 0x65, 0x61,
                0x72, 0x64, 0x20, 0x79, 0x6f, 0x75, 0x20, 0x63, 0x72, 0x79, 0x20, 0x65, 0x76, 0x65, 0x72, 0x79, 0x20, 0x6e, 0x69,
                0x67, 0x68, 0x74, 0x20, 0x69, 0x6e, 0x20, 0x79, 0x6f, 0x75, 0x72, 0x20, 0x73, 0x6c, 0x65, 0x65, 0x70, 0x0a, 0x49,
                0x20, 0x77, 0x61, 0x73, 0x20, 0x73, 0x6f, 0x20, 0x79, 0x6f, 0x75, 0x6e, 0x67, 0x0a, 0x59, 0x6f, 0x75, 0x20, 0x73,
                0x68, 0x6f, 0x75, 0x6c, 0x64, 0x20, 0x68, 0x61, 0x76, 0x65, 0x20, 0x6b, 0x6e, 0x6f, 0x77, 0x6e, 0x20, 0x62, 0x65,
                0x74, 0x74, 0x65, 0x72, 0x20, 0x74, 0x68, 0x61, 0x6e, 0x20, 0x74, 0x6f, 0x20, 0x6c, 0x65, 0x61, 0x6e, 0x20, 0x6f,
                0x6e, 0x20, 0x6d, 0x65, 0x0a, 0x59, 0x6f, 0x75, 0x20, 0x6e, 0x65, 0x76, 0x65, 0x72, 0x20, 0x74, 0x68, 0x6f, 0x75,
                0x67, 0x68, 0x74, 0x20, 0x6f, 0x66, 0x20, 0x61, 0x6e, 0x79, 0x6f, 0x6e, 0x65, 0x20, 0x65, 0x6c, 0x73, 0x65, 0x0a,
                0x59, 0x6f, 0x75, 0x20, 0x6a, 0x75, 0x73, 0x74, 0x20, 0x73, 0x61, 0x77, 0x20, 0x79, 0x6f, 0x75, 0x72, 0x20, 0x70,
                0x61, 0x69, 0x6e, 0x0a, 0x41, 0x6e, 0x64, 0x20, 0x6e, 0x6f, 0x77, 0x20, 0x49, 0x20, 0x63, 0x72, 0x79, 0x20, 0x69,
                0x6e, 0x20, 0x74, 0x68, 0x65, 0x20, 0x6d, 0x69, 0x64, 0x64, 0x6c, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x74, 0x68, 0x65,
                0x20, 0x6e, 0x69, 0x67, 0x68, 0x74, 0x0a, 0x46, 0x6f, 0x72, 0x20, 0x74, 0x68, 0x65, 0x20, 0x73, 0x61, 0x6d, 0x65,
                0x20, 0x64, 0x61, 0x6d, 0x6e, 0x20, 0x74, 0x68, 0x69, 0x6e, 0x67, 0x0a, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73,
                0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49, 0x20, 0x6e, 0x65, 0x76, 0x65, 0x72, 0x20, 0x73, 0x74,
                0x72, 0x61, 0x79, 0x20, 0x74, 0x6f, 0x6f, 0x20, 0x66, 0x61, 0x72, 0x20, 0x66, 0x72, 0x6f, 0x6d, 0x20, 0x74, 0x68,
                0x65, 0x20, 0x73, 0x69, 0x64, 0x65, 0x77, 0x61, 0x6c, 0x6b, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20,
                0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49, 0x20, 0x6c, 0x65, 0x61, 0x72, 0x6e, 0x65, 0x64, 0x20, 0x74, 0x6f,
                0x20, 0x70, 0x6c, 0x61, 0x79, 0x20, 0x6f, 0x6e, 0x20, 0x74, 0x68, 0x65, 0x20, 0x73, 0x61, 0x66, 0x65, 0x20, 0x73,
                0x69, 0x64, 0x65, 0x20, 0x73, 0x6f, 0x20, 0x49, 0x20, 0x64, 0x6f, 0x6e, 0x20, 0x74, 0x20, 0x67, 0x65, 0x74, 0x20,
                0x68, 0x75, 0x72, 0x74, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75,
                0x0a, 0x49, 0x20, 0x74, 0x72, 0x79, 0x20, 0x6d, 0x79, 0x20, 0x68, 0x61, 0x72, 0x64, 0x65, 0x73, 0x74, 0x20, 0x6a,
                0x75, 0x73, 0x74, 0x20, 0x74, 0x6f, 0x20, 0x66, 0x6f, 0x72, 0x67, 0x65, 0x74, 0x20, 0x65, 0x76, 0x65, 0x72, 0x79,
                0x74, 0x68, 0x69, 0x6e, 0x67, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f,
                0x75, 0x0a, 0x49, 0x20, 0x64, 0x6f, 0x6e, 0x20, 0x74, 0x20, 0x6b, 0x6e, 0x6f, 0x77, 0x20, 0x68, 0x6f, 0x77, 0x20,
                0x74, 0x6f, 0x20, 0x6c, 0x65, 0x74, 0x20, 0x61, 0x6e, 0x79, 0x6f, 0x6e, 0x65, 0x20, 0x65, 0x6c, 0x73, 0x65, 0x20,
                0x69, 0x6e, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49,
                0x20, 0x6d, 0x20, 0x61, 0x73, 0x68, 0x61, 0x6d, 0x65, 0x64, 0x20, 0x6f, 0x66, 0x20, 0x6d, 0x79, 0x20, 0x6c, 0x69,
                0x66, 0x65, 0x20, 0x62, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x69, 0x74, 0x20, 0x73, 0x20, 0x65, 0x6d, 0x70,
                0x74, 0x79, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x49,
                0x20, 0x61, 0x6d, 0x20, 0x61, 0x66, 0x72, 0x61, 0x69, 0x64, 0x0a, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65,
                0x20, 0x6f, 0x66, 0x20, 0x79, 0x6f, 0x75, 0x0a, 0x42, 0x65, 0x63, 0x61, 0x75, 0x73, 0x65, 0x20, 0x6f, 0x66, 0x20,
                0x79, 0x6f, 0x75, 0x0a, 0x2e, 0x2e, 0x2e, 0x0a, /*0x0a, 0x66, 0x6f, 0x72, 0x20, 0x6a, 0x75, 0x6c, 0x79, 0x0a, 0x0a,*/
        });

        System.out.println(str);



    }

    private void demo() {
        while (true) {
        }
    }

}
