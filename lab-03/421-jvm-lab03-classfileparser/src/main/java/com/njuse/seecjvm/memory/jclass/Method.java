package com.njuse.seecjvm.memory.jclass;

import com.njuse.seecjvm.classloader.classfileparser.MethodInfo;
import com.njuse.seecjvm.classloader.classfileparser.attribute.CodeAttribute;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Method extends ClassMember {
    private int maxStack;
    private int maxLocal;
    private int argc;
    private byte[] code;

    public Method(MethodInfo info, JClass clazz) {
        this.clazz = clazz;
        accessFlags = info.getAccessFlags();
        name = info.getName();
        descriptor = info.getDescriptor();

        CodeAttribute codeAttribute = info.getCodeAttribute();
        if (codeAttribute != null) {
            maxLocal = codeAttribute.getMaxLocal();
            maxStack = codeAttribute.getMaxStack();
            code = codeAttribute.getCode();
        }
        argc = calculateArgcFromDescriptor(descriptor);
    }
    //todo calculateArgcFromDescriptor

    private int calculateArgcFromDescriptor(String descriptor) {
        /**
         * Add some codes here.
         * Here are some examples in README!!!
         *
         * You should refer to JVM specification for more details
         *
         * Beware of long and double type
         */
        int start = descriptor.indexOf('(');
        int end = descriptor.indexOf(')');

        if (start == -1 || end == -1) {
            return 0;
        }

        String inArgs = descriptor.substring(start + 1, end);

        int argc = 0;

        for (int i = 0; i < inArgs.length(); i++) {
            char c = inArgs.charAt(i);
            if (c == 'B' || c == 'C' || c == 'I' || c == 'S' || c == 'Z') {
                argc++;
            } else if (c == 'F') {
                argc++;
            } else if (c == 'J' || c == 'D') {
                argc += 2;
            } else if (c == 'L') {
                int semicolonIndex = inArgs.indexOf(';', i);
                i = semicolonIndex;
                argc++;
            } else if (c == '[') {
                while (inArgs.charAt(i + 1) == '[') {
                    i++;
                }
                if (inArgs.charAt(i + 1) == 'L') {
                    int semicolonIndex = inArgs.indexOf(';', i + 1);
                    i = semicolonIndex;
                }
                argc++;
            }
        }
        return argc;
    }
}
