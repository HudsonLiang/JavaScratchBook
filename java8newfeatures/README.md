#Sales Tax Problem

Sales Tax problem is a well known OO programming problem from Thoughtworks. It appeared many years ago and there are many
discussions on Internet.

No to discuss OO design of this problem here. What is interesting is how to program it using Java 8's new features: Stream, Functional interfaces and Lambda expressions

##Function, Functional Interface
First, each tax is a perfect example of <code>Function</code>.

Every tax is a <code>Function</code> and run this function to get the tax value. Calculating one tax is like:<code>Taxes.importTax().apply(item)</code>. 

##Stream
With <code>Stream</code>, there is no loop in loop to sum up taxes and costs. Code becomes very expressive.Every tax value is result of tax function and can be put into a mutable List, and then calculate sum against stream of the list in just one statement. <code>orderTax.stream().mapToDouble(d -> d).sum()</code>

##Others

###Enum
Enum in Java is powerful. Common behaviors among Enum constants can be defined as methods and constructor. Which taxes are applicable to a kind of goods is defined in Goods.

###Big Decimal
It is important to do tax calculation in <code>BigDecimal</code> because it requires precision. It is easier to do roundup in <code>BigDecimal</code>.    


