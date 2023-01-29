package com.zbw.test;

import com.squareup.protoparser.*;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhangbaowei
 * @description:
 * @date 2023/1/29 10:56
 */
public class ProtoGeneratorTest {

    @Test
    public void printFile() throws IOException {
        ProtoFile expected = ProtoFile.builder("test.proto")
                .syntax(ProtoFile.Syntax.PROTO_3)
                .packageName("package.zbw911.test")
                .addOption(OptionElement.create("java_package", OptionElement.Kind.STRING, "com.zbw911.test"))
                .addOption(OptionElement.create("java_multiple_files", OptionElement.Kind.BOOLEAN, "true"))
                .addType(MessageElement.builder().name("Foo").build())
                .addType(MessageElement.builder().name("requestType").build())
                .addType(MessageElement.builder().name("responeType")
                        .addField(FieldElement.builder()
                                .label(FieldElement.Label.REPEATED)
                                .type(DataType.NamedType.ScalarType.INT32)
                                .name("repppppint")
                                .tag(2)
                                .build())
                        .build())
                .addService(ServiceElement.builder()
                        .name("aaa")
                        .documentation("service doc")
                        .addRpc(RpcElement.builder()
                                .name("rpc1")
                                .documentation("rpc doc")
                                .requestType(DataType.NamedType.create("requestType"))
                                .responseType(DataType.NamedType.create("responeType"))
//                                .addOption(OptionElement.create("o", OptionElement.Kind.NUMBER, 123, false))
                                .build())
                        .addRpc(RpcElement.builder()
                                .name("rpc2")
                                .documentation("rpc2 doc")
                                .requestType(DataType.NamedType.create("requestType"))
                                .responseType(DataType.NamedType.create("responeType"))
//                                .addOption(OptionElement.create("o", OptionElement.Kind.NUMBER, 123, false))
                                .build())
                        .build())
                .addType(MessageElement.builder()
                        .name("FieldOptions")
                        .addField(FieldElement.builder()
//                                .label(FieldElement.Label.OPTIONAL)
                                .type(DataType.NamedType.create("CType"))
                                .name("ctype")
                                .tag(1)
//                                .addOption(OptionElement.create("default", OptionElement.Kind.ENUM, "STRING"))
//                                .addOption(OptionElement.create("deprecated", OptionElement.Kind.BOOLEAN, "true"))
                                .build())
                        .addType(EnumElement.builder()
                                .name("CType")
                                .qualifiedName("FieldOptions.CType")
                                .addConstant(EnumConstantElement.builder()
                                        .name("STRING")
                                        .tag(0)
//                                        .addOption(OptionElement.create("opt_a", OptionElement.Kind.NUMBER, "1", true))
//                                        .addOption(OptionElement.create("opt_b", OptionElement.Kind.NUMBER, "2", true))
                                        .build())
                                .build())
//                        .addExtensions(ExtensionsElement.create(500, 500,
//                                "Clients can define custom options in extensions of this message. See above."))
//                        .addExtensions(ExtensionsElement.create(1000, 5000))
                        .build())
                .build();

        String x = expected.toSchema();
        System.out.println(x);

        if (true) {
            return;
        }
        File file = new File("src/main/proto/v1/test.proto");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(x);
        bw.close();

        System.out.println("Done");

    }
}