---

layout: card
category: realisation

---

Favor composition over inheritance

---

Also known as the &lsquo;composite reuse principle&rsquo;. Favor composition
over inheritance to achieve polymorphism.

---

### Also known as

Composite Reuse Principle

### Motivation

When some behavior of a domain object can change with other features remaining the same.

### Applicability

Whenever class hierarchies are being created to specialize behavior then behavior could be extracted in an interface. The primary object would delegate the behavior to interface implementations.

This approach avoids the number of classes to be created. Same set of classes composed differently give different run-time behavior.

### Application

Design classes to use interfaces for variable behavior and delegate the behavior to a concrete class.

### Consequences

Lesser number of classes and multiple behavior with composition.

Extensibility

### Samples

If you have different devices that use the same software and only differ in the display hardware. Then you could use two approaches.

# Template Method

    public class Device {
     public void display() {
        // Basic display
     }
    }

    public class LEDDisplayDevice {
     public void display() {
     }
    }

    public class ExternalDisplayDevice {
     public void display() {
     }
    }

# Using Composition (Strategy Pattern)

    public class Device {
     private Display display;

     public Device(Display display) {
       this.display = display;
     }

     public void display() {
        this.display.display();
     }
    }

    public class LEDDisplay {
     public void display() {
     }
    }

    public class ExternalDisplay {
     public void display() {
     }
    }

### References

[Composite Reuse Principle](http://www.cs.sjsu.edu/~pearce/cs251b/principles/crp.htm)


