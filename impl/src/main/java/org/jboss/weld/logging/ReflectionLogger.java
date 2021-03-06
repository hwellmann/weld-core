/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.logging;

import static org.jboss.weld.logging.WeldLogger.WELD_PROJECT_CODE;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.Message.Format;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.weld.exceptions.DefinitionException;
import org.jboss.weld.exceptions.IllegalArgumentException;
import org.jboss.weld.exceptions.WeldException;

/**
 * Log messages relating to reflection
 *
 * Message ids: 000600 - 000699
 */
@MessageLogger(projectCode = WELD_PROJECT_CODE)
public interface ReflectionLogger extends WeldLogger {

    ReflectionLogger LOG = Logger.getMessageLogger(ReflectionLogger.class, Category.REFLECTION.getName());

    @LogMessage(level = Level.DEBUG)
    @Message(id = 600, value = "{0} is missing @Retention(RUNTIME). Weld will use this annotation, however this may make the application unportable.", format = Format.MESSAGE_FORMAT)
    void missingRetention(Object param1);

    @LogMessage(level = Level.DEBUG)
    @Message(id = 601, value = "{0} is missing @Target. Weld will use this annotation, however this may make the application unportable.", format = Format.MESSAGE_FORMAT)
    void missingTarget(Object param1);

    @LogMessage(level = Level.DEBUG)
    @Message(id = 602, value = "{0} is not declared @Target(TYPE, METHOD) or @Target(TYPE). Weld will use this annotation, however this may make the application unportable.", format = Format.MESSAGE_FORMAT)
    void missingTargetTypeMethodOrTargetType(Object param1);

    /**
     * @deprecated Not in use
     */
    @Deprecated
    @Message(id = 603, value = "{0} is declared @Target(TYPE, METHOD), but inherits {1}, which is declared @Target(TYPE). Weld will use this annotation, however this may make the application unportable.", format = Format.MESSAGE_FORMAT)
    String targetTypeMethodInheritsFromTargetType(Object param1, Object param2);

    @LogMessage(level = Level.DEBUG)
    @Message(id = 604, value = "{0} is not declared @Target(METHOD, FIELD, TYPE). Weld will use this annotation, however this may make the application unportable.", format = Format.MESSAGE_FORMAT)
    void missingTargetMethodFieldType(Object param1);

    @LogMessage(level = Level.DEBUG)
    @Message(id = 605, value = "{0} is not declared @Target(METHOD, FIELD, TYPE, PARAMETER), @Target(METHOD, TYPE), @Target(METHOD), @Target(TYPE) or @Target(FIELD). Weld will use this annotation, however this may make the application unportable.", format = Format.MESSAGE_FORMAT)
    void missingTargetMethodFieldTypeParameterOrTargetMethodTypeOrTargetMethodOrTargetTypeOrTargetField(Object param1);

    @Message(id = 606, value = "Unable to determine name of parameter")
    IllegalArgumentException unableToGetParameterName();

    @Message(id = 607, value = "annotationMap cannot be null")
    WeldException annotationMapNull();

    @Message(id = 608, value = "declaredAnnotationMap cannot be null")
    WeldException declaredAnnotationMapNull();

    /**
     * @deprecated Not in use
     */
    @Deprecated
    @Message(id = 609, value = "Cleaning Javassist proxy. Class {0}", format = Format.MESSAGE_FORMAT)
    String cleaningJavassistProxyClass(Object param1);

    @Message(id = 610, value = "Unable to deserialize constructor. Declaring class {0}, signature {1}", format = Format.MESSAGE_FORMAT)
    WeldException unableToGetConstructorOnDeserialization(Object param1, Object param2, @Cause Throwable cause);

    @Message(id = 611, value = "Unable to deserialize method. Declaring class {0}, signature {1}", format = Format.MESSAGE_FORMAT)
    WeldException unableToGetMethodOnDeserialization(Object param1, Object param2, @Cause Throwable cause);

    @Message(id = 612, value = "Unable to deserialize field. Declaring class {0}, field name {1}", format = Format.MESSAGE_FORMAT)
    WeldException unableToGetFieldOnDeserialization(Object param1, Object param2, @Cause Throwable cause);

    /**
     * @deprecated Not in use
     */
    @Deprecated
    @Message(id = 613, value = "Unable to deserialize parameter. Declaring class {0}, parameter {2} of method with signature {1}", format = Format.MESSAGE_FORMAT)
    String unableToGetParameterOnDeserialization(Object param1, Object param2, Object param3);

    @Message(id = 614, value = "Incorrect number of AnnotatedParameters {0} on AnnotatedMethod {1}. AnnotatedMethod has {2} as parameters but should have {3} as parameters", format = Format.MESSAGE_FORMAT)
    DefinitionException incorrectNumberOfAnnotatedParametersMethod(Object param1, Object param2, Object param3, Object param4);

    /**
     * @deprecated Not in use
     */
    @Deprecated
    @Message(id = 615, value = "Incorrect number of AnnotatedParameters {0} on AnnotatedConstructor {1}. AnnotatedConstructor has {2} as parameters but should have {3} as parameters", format = Format.MESSAGE_FORMAT)
    String incorrectNumberOfAnnotatedParametersConstructor(Object param1, Object param2, Object param3, Object param4);

    @Message(id = 616, value = "Instantiation through ReflectionFactory of {0} failed", format = Format.MESSAGE_FORMAT)
    WeldException reflectionfactoryInstantiationFailed(Object param1, @Cause Throwable cause);

    @Message(id = 617, value = "Instantiation through Unsafe of {0} failed", format = Format.MESSAGE_FORMAT)
    WeldException unsafeInstantiationFailed(Object param1, @Cause Throwable cause);

    /**
     * @deprecated Not in use
     */
    @Deprecated
    @Message(id = 618, value = "Could not set MethodHandler on {0}", format = Format.MESSAGE_FORMAT)
    String methodhandlerSetFailed(Object param1);

    @Message(id = 619, value = "An interceptor for lifecycle callbacks {0} declares and interceptor binding {1} with METHOD as its @Target.", format = Format.MESSAGE_FORMAT)
    DefinitionException methodElementTypeNotAllowed(Object param1, Object param2);

    @LogMessage(level = Level.DEBUG)
    @Message(id = 620, value = "{0} is not declared @Target(METHOD, FIELD, PARAMETER, TYPE). Weld will use this annotation, however this may make the application unportable.", format = Format.MESSAGE_FORMAT)
    void missingTargetMethodFieldParameterType(Object param1);

    @LogMessage(level = Level.WARN)
    @Message(id = 621, value = "Interceptor binding {0} with @Target defined as {1} should not be applied on interceptor binding {2} with @Target definition: {3}", format = Format.MESSAGE_FORMAT)
    void invalidInterceptorBindingTargetDeclaration(Object param1, Object param2, Object param3, Object param4);

}