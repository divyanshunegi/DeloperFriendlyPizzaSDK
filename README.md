# Developer Friendly Pizza SDK

A simple SDK which you can integrate in your existing app and access Pizza Ordering menu directly on just 1 command.

![Image of sample pizza menu 1](https://github.com/divyanshunegi/DeloperFriendlyPizzaSDK/blob/master/sample_images/1.png)

![Image of sample pizza menu 2](https://github.com/divyanshunegi/DeloperFriendlyPizzaSDK/blob/master/sample_images/2.png)


## Installation

You can easily add this library by adding `jcenter()` in your `build.gradle` file as shown below:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

after this add the dependency with the latest version of the PizzaSDK library

```
dependencies {
	        implementation 'com.github.divyanshunegi:DeloperFriendlyPizzaSDK:Tag'
	}
```

## Usage

### Step 1

The first thing is to initialize the library in your Application file, If you do not have an application file please add it in your Manifest and make one.
and in the `onCreate()` method of Application file add this code to initialize

```
        new PizzaSDK.Builder(this)
                .build();
```

Thats it, the SDK is initialized and once you run the build it will show a pizza emoji toast like this 🍕.

### Step 2

Now in you can add the method given below at any point in your app to trigger the menu, so in case you have a button you can add this on its `onClick()` method.

```
    public void orderPizza(View view) {
        PizzaSDK.pizzaTime();
    }
```

and Thats it, you will have the menu in your app with all the functionalities.

Thanks for using the SDK, it is a fun project nothing serious, dont keep waiting for the pizza after ordering :D

