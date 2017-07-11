# Grails 3.2.11 Plugins Backward Compatibility Issue

Plugin `plugin-3.2.11` is created using Grails 3.2.11 and only defines blank interceptor.

Application `app-3.2.10` is created using Grails 3.2.10 and only defines dependency on `plugin-3.2.11` JAR.

Run `./gradlew :app-3.2.10:bootRun` to get following error:

```
app-3.2.10:bootRun
objc[62215]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/bin/java (0x10b0f94c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre/lib/libinstrument.dylib (0x10b1c64e0). One of the two will be used. Which one is undefined.
2017-07-11 11:32:16.679 ERROR --- [ost-startStop-1] o.s.b.c.embedded.tomcat.TomcatStarter    : Error starting Tomcat context. Exception: org.springframework.beans.factory.BeanCreationException. Message: Error creating bean with name 'grailsCacheFilter': Cannot create inner bean '(inner bean)#138e0d79' of type [grail [hasinterceptor.TesterInterceptor@6ce4f245]
2017-07-11 11:32:16.735 ERROR --- [           main] o.s.boot.SpringApplication               : Application startup failed

org.springframework.context.ApplicationContextException: Unable to start embedded container; nested exception is org.springframework.boot.context.embedded.EmbeddedServletContainerException: Unable to start embedded Tomcateption: Error creating bean with name 'testerInterceptor': Instantiation of bean failed; nested e        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh(EmbeddedWebApplicationContext.java:137)tor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is a        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:536)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:372)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:316)
        at grails.boot.GrailsApp.run(GrailsApp.groovy:83)
        at grails.boot.GrailsApp.run(GrailsApp.groovy:388)
        at grails.boot.GrailsApp.run(GrailsApp.groovy:375)
        at grails.boot.GrailsApp$run.call(Unknown Source)
        at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:113)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:133)
        at usesplugin.Application.main(Application.groovy:8)
Caused by: org.springframework.boot.context.embedded.EmbeddedServletContainerException: Unable to start embedded Tomcat
        at org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer.initialize(TomcatEmbeddedServletContainer.java:123)
        at org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer.<init>(TomcatEmbeddedServletContainer.java:84)
        at org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory.getTomcatEmbeddedServletContainer(TomcatEmbeddedServletContainerFactory.java:552)
        at org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory.getEmbeddedServletContainer(TomcatEmbeddedServletContainerFactory.java:177)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer(EmbeddedWebApplicationContext.java:164)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh(EmbeddedWebApplicationContext.java:134)
        ... 13 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'grailsCacheFilter': Cannot create inner bean '(inner bean)#138e0d79' of type [grails.plugin.cache.web.filter.simple.MemoryPageFragmentCachingFilter] while setting bean property 'filter'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '(inner bean)#138e0d79': Unsatisfied dependency expressed through method 'setUrlMappingsHandlerMapping' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'urlMappingsHandlerMapping': Unsatisfied dependency expressed through method 'setHandlerInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'grailsInterceptorMappedInterceptor': Cannot create inner bean '(inner bean)#6e969ef0' of type [org.grails.plugins.web.interceptors.GrailsInterceptorHandlerInterceptorAdapter] while setting constructor argument; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '(inner bean)#6e969ef0': Unsatisfied dependency expressed through method 'setInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'testerInterceptor': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [hasinterceptor.TesterInterceptor]: Constructor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:313)
        at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:129)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1531)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1276)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
        at org.springframework.boot.web.servlet.ServletContextInitializerBeans.getOrderedBeansOfType(ServletContextInitializerBeans.java:234)
        at org.springframework.boot.web.servlet.ServletContextInitializerBeans.getOrderedBeansOfType(ServletContextInitializerBeans.java:215)
        at org.springframework.boot.web.servlet.ServletContextInitializerBeans.addServletContextInitializerBeans(ServletContextInitializerBeans.java:91)
        at org.springframework.boot.web.servlet.ServletContextInitializerBeans.<init>(ServletContextInitializerBeans.java:79)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getServletContextInitializerBeans(EmbeddedWebApplicationContext.java:241)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.selfInitialize(EmbeddedWebApplicationContext.java:228)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.access$000(EmbeddedWebApplicationContext.java:89)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext$1.onStartup(EmbeddedWebApplicationContext.java:213)
        at org.springframework.boot.context.embedded.tomcat.TomcatStarter.onStartup(TomcatStarter.java:55)
        at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5196)
        at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
        at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1419)
        at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1409)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:744)
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '(inner bean)#138e0d79': Unsatisfied dependency expressed through method 'setUrlMappingsHandlerMapping' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'urlMappingsHandlerMapping': Unsatisfied dependency expressed through method 'setHandlerInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'grailsInterceptorMappedInterceptor': Cannot create inner bean '(inner bean)#6e969ef0' of type [org.grails.plugins.web.interceptors.GrailsInterceptorHandlerInterceptorAdapter] while setting constructor argument; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '(inner bean)#6e969ef0': Unsatisfied dependency expressed through method 'setInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'testerInterceptor': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [hasinterceptor.TesterInterceptor]: Constructor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:667)
        at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:366)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1264)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:299)
        ... 26 common frames omitted
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'urlMappingsHandlerMapping': Unsatisfied dependency expressed through method 'setHandlerInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'grailsInterceptorMappedInterceptor': Cannot create inner bean '(inner bean)#6e969ef0' of type [org.grails.plugins.web.interceptors.GrailsInterceptorHandlerInterceptorAdapter] while setting constructor argument; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '(inner bean)#6e969ef0': Unsatisfied dependency expressed through method 'setInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'testerInterceptor': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [hasinterceptor.TesterInterceptor]: Constructor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:667)
        at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:366)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1264)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:659)
        ... 32 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'grailsInterceptorMappedInterceptor': Cannot create inner bean '(inner bean)#6e969ef0' of type [org.grails.plugins.web.interceptors.GrailsInterceptorHandlerInterceptorAdapter] while setting constructor argument; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '(inner bean)#6e969ef0': Unsatisfied dependency expressed through method 'setInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'testerInterceptor': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [hasinterceptor.TesterInterceptor]: Constructor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:313)
        at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:129)
        at org.springframework.beans.factory.support.ConstructorResolver.resolveConstructorArguments(ConstructorResolver.java:648)
        at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:145)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1193)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1095)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.addCandidateEntry(DefaultListableBeanFactory.java:1309)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.findAutowireCandidates(DefaultListableBeanFactory.java:1275)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveMultipleBeans(DefaultListableBeanFactory.java:1160)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1096)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:659)
        ... 45 common frames omitted
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '(inner bean)#6e969ef0': Unsatisfied dependency expressed through method 'setInterceptors' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'testerInterceptor': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [hasinterceptor.TesterInterceptor]: Constructor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:667)
        at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:366)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1264)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:299)
        ... 63 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'testerInterceptor': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [hasinterceptor.TesterInterceptor]: Constructor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1155)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1099)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.addCandidateEntry(DefaultListableBeanFactory.java:1309)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.findAutowireCandidates(DefaultListableBeanFactory.java:1275)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveMultipleBeans(DefaultListableBeanFactory.java:1160)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1096)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:659)
        ... 69 common frames omitted
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [hasinterceptor.TesterInterceptor]: Constructor threw exception; nested exception is groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:154)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:89)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1147)
        ... 83 common frames omitted
Caused by: groovy.lang.MissingMethodException: No signature of method: static grails.artefact.Interceptor.$init$grails_artefact_Interceptor__matchers() is applicable for argument types: (hasinterceptor.TesterInterceptor) values: [hasinterceptor.TesterInterceptor@6ce4f245]
        at groovy.lang.MetaClassImpl.invokeStaticMissingMethod(MetaClassImpl.java:1506)
        at groovy.lang.MetaClassImpl.invokeStaticMethod(MetaClassImpl.java:1492)
        at org.codehaus.groovy.runtime.InvokerHelper.invokeMethod(InvokerHelper.java:899)
        at org.codehaus.groovy.runtime.ScriptBytecodeAdapter.invokeMethodN(ScriptBytecodeAdapter.java:168)
        at grails.artefact.Interceptor$Trait$Helper.$static_methodMissing(Interceptor.groovy)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:483)
        at org.springsource.loaded.ri.ReflectiveInterceptor.jlrMethodInvoke(ReflectiveInterceptor.java:1426)
        at org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:93)
        at groovy.lang.MetaClassImpl.invokeStaticMissingMethod(MetaClassImpl.java:1504)
        at groovy.lang.MetaClassImpl.invokeStaticMethod(MetaClassImpl.java:1492)
        at org.codehaus.groovy.runtime.callsite.StaticMetaClassSite.callStatic(StaticMetaClassSite.java:65)
        at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallStatic(CallSiteArray.java:56)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callStatic(AbstractCallSite.java:194)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callStatic(AbstractCallSite.java:206)
        at hasinterceptor.TesterInterceptor.<init>(TesterInterceptor.groovy)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:408)
        at org.springsource.loaded.ri.ReflectiveInterceptor.jlrConstructorNewInstance(ReflectiveInterceptor.java:1075)
        at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:142)
        ... 85 common frames omitted

:app-3.2.10:bootRun FAILED
```

If you upgrade the application to version `3.2.11` as well then there is no error anymore.