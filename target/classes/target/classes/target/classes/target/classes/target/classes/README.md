```swift
java-annotations-lab/
│
├── phase1-core-annotations/
│   ├── src/main/java/com/annotations/core/
│   │   ├── annotations/
│   │   │   ├── OverrideExample.java
│   │   │   ├── DeprecatedExample.java
│   │   │   └── LogExecutionTime.java
│   │   ├── examples/
│   │   │   ├── ExampleUsage.java
│   │   │   └── ReflectionReader.java
│   │   └── README.md
│   └── pom.xml
│
├── phase2-validation-annotations/
│   ├── src/main/java/com/annotations/validation/
│   │   ├── annotations/
│   │   │   ├── NotNull.java
│   │   │   ├── Range.java
│   │   │   └── Email.java
│   │   ├── processor/
│   │   │   └── Validator.java
│   │   ├── examples/
│   │   │   └── ValidationDemo.java
│   │   └── README.md
│   └── pom.xml
│
├── phase3-validation-engine/
│   ├── src/main/java/com/annotations/engine/
│   │   ├── core/
│   │   │   ├── ValidationEngine.java
│   │   │   ├── ValidationException.java
│   │   │   └── ValidationResult.java
│   │   ├── annotations/  ← You’ll reuse from previous phase
│   │   ├── examples/
│   │   │   └── RunValidation.java
│   │   └── README.md
│   └── pom.xml
│
├── phase4-ioc-container/
│   ├── src/main/java/com/annotations/ioc/
│   │   ├── annotations/
│   │   │   ├── Component.java
│   │   │   ├── Service.java
│   │   │   ├── Repository.java
│   │   │   └── Autowired.java
│   │   ├── core/
│   │   │   ├── BeanRegistry.java
│   │   │   ├── DependencyInjector.java
│   │   │   └── ApplicationContext.java
│   │   ├── examples/
│   │   │   └── IoCDemo.java
│   │   └── README.md
│   └── pom.xml
│
├── phase5-configuration-rest/
│   ├── src/main/java/com/annotations/web/
│   │   ├── annotations/
│   │   │   ├── Configuration.java
│   │   │   ├── Bean.java
│   │   │   ├── Controller.java
│   │   │   ├── GetMapping.java
│   │   │   └── RequestMapping.java
│   │   ├── core/
│   │   │   ├── ConfigProcessor.java
│   │   │   ├── Router.java
│   │   │   └── HttpServerMini.java
│   │   ├── examples/
│   │   │   └── RestDemo.java
│   │   └── README.md
│   └── pom.xml
│
├── phase6-aop-proxies/
│   ├── src/main/java/com/annotations/aop/
│   │   ├── annotations/
│   │   │   ├── LogExecutionTime.java
│   │   │   └── Transactional.java
│   │   ├── core/
│   │   │   ├── ProxyFactory.java
│   │   │   ├── AspectHandler.java
│   │   │   └── MethodInterceptor.java
│   │   ├── examples/
│   │   │   └── AOPDemo.java
│   │   └── README.md
│   └── pom.xml
│
├── common/  ← reusable utilities across phases
│   ├── src/main/java/com/annotations/common/
│   │   ├── ReflectionUtils.java
│   │   ├── ClassScanner.java
│   │   └── PrintUtils.java
│   └── pom.xml
│
└── README.md
```
