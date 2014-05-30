package com.blogspot.toomuchcoding.spock.subjcollabs

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FieldInfo
import org.spockframework.runtime.model.SpecInfo

class SubjectsCollaboratorsExtension extends AbstractAnnotationDrivenExtension<Subject> {

    private final SubjectsCollaboratorsInterceptor interceptor = new SubjectsCollaboratorsInterceptor()
    
    @Override
    @SuppressWarnings(['UnnecessaryGetter', 'GroovyGetterCallCanBePropertyAccess'])
    void visitFieldAnnotation(Subject annotation, FieldInfo field) {
        interceptor.add(field)
    }

    @Override
    public void visitSpec(SpecInfo spec) {
        interceptor.install(spec.getTopSpec().getSetupMethod())
    }

}
