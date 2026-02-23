# Design Patterns Demo (Java)

Bu repo, Java ile 22 adet Design Pattern'i pratik ederek ogrenmek icin hazirladigim bir calismadir.
Amacim her pattern'i kucuk, okunabilir ve calisir bir ornekle anlamak; nerede kullanildigini ve trade-off'larini gormekti.

## Proje Kapsami

Projede 3 ana kategori bulunuyor:
- Creational Patterns
- Structural Patterns
- Behavioral Patterns

Her pattern icin:
- Ayrı bir klasor/orn ek dosyasi
- Kisa aciklama (amac, ne zaman kullanilir, arti/eksi)
- `main` method ile calisir demo

## Eklenen Pattern'ler (22)

### Creational (5)
- Factory Method
- Abstract Factory
- Builder
- Singleton
- Prototype

### Structural (7)
- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

### Behavioral (10)
- Chain of Responsibility
- Command
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Template Method
- Visitor

## Projeyi Calistirma

### 1) Derleme
```bash
javac -d out $(find src -name '*.java')
```

### 2) Ornek Calistirma
Ornek olarak:
```bash
java -cp out patterns.creational.factorymethod.Demo
java -cp out patterns.structural.proxy.ProxyExample
java -cp out patterns.behavioral.visitor.VisitorExample
```

### 3) Tum Ornekleri Hızlı Kontrol
```bash
for main in \
patterns.creational.factorymethod.Demo \
patterns.creational.abstractfactory.AbstractFactoryExample \
patterns.creational.builder.BuilderExample \
patterns.creational.singleton.SingletonExample \
patterns.creational.prototype.PrototypeExample \
patterns.structural.adapter.AdapterExample \
patterns.structural.bridge.BridgeExample \
patterns.structural.composite.CompositeExample \
patterns.structural.decorator.DecoratorExample \
patterns.structural.facade.FacadeExample \
patterns.structural.flyweight.FlyweightExample \
patterns.structural.proxy.ProxyExample \
patterns.behavioral.chain.ChainOfResponsibilityExample \
patterns.behavioral.command.CommandExample \
patterns.behavioral.iterator.IteratorExample \
patterns.behavioral.mediator.MediatorExample \
patterns.behavioral.memento.MementoExample \
patterns.behavioral.observer.ObserverExample \
patterns.behavioral.state.StateExample \
patterns.behavioral.strategy.StrategyExample \
patterns.behavioral.templatemethod.TemplateMethodExample \
patterns.behavioral.visitor.VisitorExample; do
  java -cp out "$main"
done
```

## Kisa Notlar

- Kodlarda bilerek kucuk ve basit ornekler kullandim.
- Tum pattern'ler tek bir “framework” gibi degil, ogrenme odakli bagimsiz mini ornekler olarak yazildi.

## Sonuc

Bu calisma sayesinde pattern'leri ezberlemek yerine, **hangi problemi cozdugunu** ve **neden o pattern'i sececegimi** daha iyi anladim.
