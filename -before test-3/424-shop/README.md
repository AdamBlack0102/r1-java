# Shop (20分)

## 题目
我们为DonutShop开发了一个软件能够获得商店的名字、能够展示商店的商品、买商品、并且能够计算商店所需要缴纳的税金。
税金是整体收入乘以一个税率（15%）。tax = income*rate；


不久，又有一个PizzaShop找到我们需要类似的功能。但他们采用的是线性税率。
税金是整体收入乘以一个税率（15%）加上一个基数（0.1）。tax = income*rate+base;


所以，我们设计了抽象类Shop、接口Nameable和TaxCalculator。具体不同的DonutShop和PizzaShop，以及
SimpleTaxCalculator和LinearTaxCalculator。

我们在买完所有东西后，会计算一次税金。

##任务
请在//todo:add code here处补充缺失的代码，通过所有测试用例。

## 公开测试用例（公开测试用例也是计分的! 另外有 15 个非公开测试用例）

    @Test
    public void test1(){
        double tax =0;

        Shop shop = new DonutShop();
        shop.buyInventory("Donuts");

        tax =shop.calculateSalesTax();
        assertEquals(0.15,tax,0.0001);
    }

    @Test
    public void test2(){
        double tax =0;

        Shop shop = new PizzaShop();
        shop.buyInventory("Pizza");


        tax =shop.calculateSalesTax();
        assertEquals(0.25,tax,0.0001);
    }

    @Test
    public void test3(){
        double tax =0;

        Shop shop = new DonutShop();

        tax =shop.calculateSalesTax();
        assertEquals(0.0,tax,0.0001);
    }

    @Test
    public void test4(){
        double tax =0;

        DonutShop shop = new DonutShop();

        assertEquals("Sweat Donut",shop.getName());
    }

    @Test
    public void test5(){
        double tax =0;
        boolean hasItem = false;

        Shop shop = new DonutShop();
        hasItem=shop.buyInventory("Calzone");

        assertFalse(hasItem);
    }