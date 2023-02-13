# Handling of layouts (TP2)

- **Cody ADAM** in charge of the Jetpack Compose project
- **Arthur ALLAIN** in charge of the Jetpack XML project

<!-- 
TP report to be handed in to your teacher before : 26/02/2023 at 23h59
Link for the TP report: https://forms.gle/wmTKBZhJPXhckxJ46 
-->


<!-- 
Your lab report should provide all the code and a clear explanation of your implementation for each question.
The implementation can be done in Java or Kotlin. 
All the tools that you will have used for the realization of the TP must be mentioned and their mentioned and their use specified and justified. 
The report of the practical work must mention clearly mention the names of the participants and the number of the practical work and also clearly indicate the questions to which the answers refer. 
-->

## Tasks

1. [Create a Linear layout interface with a text on the left, then a button on the right](#1)
2. [Create a Linear layout interface with a text above, then a button below](#2)
3. [Create a Linear layout interface with a label on top, then a fillable text on the left below a fillable text on the left and a button on the right](#3)
4. [Do the same as in the previous question with a Relative Layout](#4)
5. [Create an interface with a list View that will display the content of an arraylist that you have that you will have filled in beforehand with the names of the 4 Breton departments](#5)
6. [Same exercise as in the previous question but add at the end of the display of each department name the suffix the suffix " - Bretagne" at the end of each department name](#6)
7. [Finally, make it possible to click on each of the items in the list and display a popup with the display a popup with the name of the department and its population which will be stored in another arrayList or a map.](#7)

## Implementations

***Note** : For the UI, we will use the **Material 3** library. This library offer some easy to use and already styled components.*

### 1 

> **Task :** Create a Linear layout interface with a text on the left, then a button on the right

<details>
<summary>Jetpack Compose solution</summary><br/>

First to display something on the app, for example a "Hello World", we need to create a `@Composable` function. This function will be called by the `setContent` function of the `MainActivity` class. 

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun App() {
    MaterialTheme {
        Text(text = "Hello World")
    }
}
```

The `@Preview` annotation is used to display the UI in the Android Studio preview. 

This is the result :

![Hello World](./assets/hello_world.png)

In order to display a text on the left and a button on the right, we need to use a `Row` composable. The `Row` composable is a layout composable that places its children horizontally. 


This is the code that solves the task:

```kotlin
@Composable
@Preview(showBackground = true)
fun Part1() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("Hello world!")
        Button(onClick = {}) {
            Text("Button !")
        }
    }
}
```
We can note the the `Row` component has two parameters : `horizontalArrangement` and `verticalAlignment`. These parameters are used to specify how the children of the `Row` composable are arranged.

If we preview the composable we will have this result :

![part1](assets/part1.1.png)

We can then add this component to the `App` composable with some styling :

```kotlin

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun App() {
    MaterialTheme {
        Box(...) { // used to add padding and scrollable to the content
            Part1()
        }
    }
}
```

The result is the following :

![part1.2](assets/part1.2.png)

</details>

<details>
<summary>Jetpack XML solution</summary><br/>

TODO
</details>

### 2

> **Task :** Create a Linear layout interface with a text above, then a button below

<details>
<summary>Jetpack Compose solution</summary><br/>

This is very similar to the previous task. We just need to use a `Column` composable instead of a `Row` composable. The `Column` composable is a layout composable that places its children vertically.

```kotlin
@Composable
@Preview(showBackground = true)
fun Part2() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Hello world!")
        Button(onClick = {}) {
            Text("Button !")
        }
    }
}
```
***Note** : the `Text` and `Button` classes are provided by the `Material 3` library*

We then add this composable to the `App` composable:

```kotlin
@Composable
@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, heightDp = 1720)
fun App() {
    MaterialTheme {
        Box(...) {
            Column(...) {
                Part1()
                Divider()
                Part2()
            }
        }
    }
}
```

***Note** : The `Divider` composable is provided by the `Material 3` library. It is used to add a separator line between the two parts.*

The result is the following :

![part2](assets/part2.png)

</details>

<details>
<summary>Jetpack XML solution</summary><br/>

TODO
</details>

### 3

> **Task :** Create a Linear layout interface with a label on top, then a fillable text on the left below a fillable text on the left and a button on the right

<details>
<summary>Jetpack Compose solution</summary><br/>

To make a more complicated layout, we can simplify the problem by breaking it down into smaller parts. All parts of the layout will be composed of a `Row` and a `Column` composable as we can see below :

```kotlin
@Composable
@Preview(showBackground = true)
fun Part3() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Text field") },
                modifier = Modifier.weight(2f)
            )
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text("Button !")
            }
        }
    }
}
```

This is the result of the `Part3` composable added to the `App` composable :

![part3](assets/part3.png)


</details>


<details>
<summary>Jetpack XML solution</summary><br/>

XML TODO
</details>


### 4

> **Task :** Do the same as in the previous question with a Relative Layout

<details>
<summary>Jetpack Compose solution</summary><br/>

With Jetpack Compose, there is no such thing as a `RelativeLayout`.

Which means that the `Part4` composable will be the same as the `Part3` composable :

![Part4](assets/part4.png)
</details>

<details>
<summary>Jetpack XML solution</summary><br/>

XML TODO
</details>

### 5

> **Task :** Create an interface with a list View that will display the content of an arraylist that you have that you will have filled in beforehand with the names of the 4 Breton departments

<details>
<summary>Jetpack Compose solution</summary><br/>

For this task, we will use the `ListItem` composable provided by the `Material 3` library. This composable is used to display a list item with a title and left icon and a trailing icon.

```kotlin
@Composable
@Preview(showBackground = true)
fun Part5() {
    val names by remember {
        mutableStateOf(
            listOf(
                "Côtes-d'Armor", "Finistère", "Ille-et-Vilaine", "Morbihan"
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Breton's departments :",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
        )
        names.forEach { name ->
            ListItem(headlineText = {
                Text(name)
            }, modifier = Modifier.fillMaxWidth(), leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            },
                shadowElevation = 4.dp
            )
        }
    }
}
```

In the above code, we can spot the use of `mutableStateOf` which is utilitary to store the state of our composable. We need to use this function to track states in Jetpack Compose. It allows us to update the UI when the state changes.

To display the list, we used `forEach` instead of hardcoding the `ListItem` composable. This is a good practice to avoid repeating code.

This is the result of the `Part5` composable added to the `App` composable :

![Alt text](assets/part5.png)
</details>


<details>
<summary>Jetpack XML solution</summary><br/>

XML TODO
</details>

### 6

> **Task :** Same exercise as in the previous question but add at the end of the display of each department name the suffix the suffix " - Bretagne" at the end of each department name

<details>
<summary>Jetpack Compose solution</summary><br/>

We could fall into the trap of hardcoding the suffix " - Bretagne" in the `ListItem` composable. But this is not a good practice. We should avoid repeating code as much as possible. This method is prone to errors and is not scalable.

Instead we add the suffix before displaying the names.
We only need to change the line :
```kotlin
Text(name)
```

To the following :
```kotlin
Text("$name - Bretagne")
```

Here is a side by side comparison of the `Part5` and `Part6` composables :

![part6](assets/part6.png)

</details>


<details>
<summary>Jetpack XML solution</summary><br/>

XML TODO
</details>

### 7

> **Task :** Finally, make it possible to click on each of the items in the list and display a popup with the display a popup with the name of the department and its population which will be stored in another arrayList or a map.

<details>
<summary>Jetpack Compose solution</summary><br/>

Let's break down this more complex task.

```kotlin
    val deps by remember {
        mutableStateOf(
            mapOf(
                "Côtes-d'Armor" to "descritpion...",
                "Finistère" to "descritpion...",
                "Ille-et-Vilaine" to "descritpion...",
                "Morbihan" to "descritpion..."
            )
        )
    }
    var openModal by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }
```
First of all, we have the state `deps` which is no longer an `arraylist` but a `map`. This is because we need to store the description of each department.

Then we have the states `openModal` and `selected` which are used to display the modal. The `openModal` state is used to know if the modal is open or not. The `selected` state is used to know which department is selected.


```kotlin
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Departments informations :",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
        )
        deps.forEach { dep ->
            ListItem(
                headlineText = {
                    Text("${dep.key} - Bretagne")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selected = dep.key; openModal = true },
                leadingContent = {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Localized description",
                    )
                },
                trailingContent = {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Localized description",
                    )
                },
                shadowElevation = 4.dp
            )
        }
    }
```

Next, we have the list of departments dispay which is quite similar to the previous one. The only difference is that we need to add is the `clickable` modifier to the `ListItem` composable.

```kotlin
    ...
    modifier = Modifier
        .fillMaxWidth()
        .clickable { selected = dep.key; openModal = true },
    ...
```

This modifier is used to make a composable clickable. It takes a lambda as a parameter. In our case, we set the `selected` state to the current department and the `openModal` state to `true`.

```kotlin
    trailingContent = {
        Icon(
            Icons.Filled.KeyboardArrowRight,
            contentDescription = "Localized description",
        )
    },
```

For visual indication that the item is clickable, we also added an icon at the end of the `ListItem` composable.

This is what we currently have :

![part7.1](assets/part7.1.png)

And finally, we have the modal display at the end of the composable.

```kotlin
    if (openModal) {
        ModalBottomSheet(
            onDismissRequest = { openModal = false },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Informations about $selected",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(deps[selected] ?: "", modifier = Modifier.padding(bottom = 60.dp))
            }
        }
    }
```

This modal is displayed when the `openModal` state is set to `true`. We used the `ModalBottomSheet` composable to display the modal provided by `Material 3` library.

Inside the modal we display the name of the department and its description. The description is stored in the `deps` map.

Note that we use the `onDismissRequest` lambda to set the `openModal` state to `false` when the modal is dismissed.

All the code combined, this is the composable code :


```kotlin
@Composable
@Preview(showBackground = true)
fun Part7() {
    val deps by remember {
        mutableStateOf(
            mapOf(
                "Côtes-d'Armor" to "descritpion...",
                "Finistère" to "descritpion...",
                "Ille-et-Vilaine" to "descritpion...",
                "Morbihan" to "descritpion..."
            )
        )
    }
    var openModal by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }



    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Departments informations :",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
        )
        deps.forEach { dep ->
            ListItem(
                headlineText = {
                    Text("${dep.key} - Bretagne")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selected = dep.key; openModal = true },
                leadingContent = {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Localized description",
                    )
                },
                trailingContent = {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Localized description",
                    )
                },
                shadowElevation = 4.dp
            )
        }
    }

    if (openModal) {
        ModalBottomSheet(
            onDismissRequest = { openModal = false },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Informations about $selected",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(deps[selected] ?: "", modifier = Modifier.padding(bottom = 60.dp))
            }
        }
    }
}
```

Here is the result of the `Part7` when we click on the first item :

![part7.2](assets/part7.2.png)







</details>


<details>
<summary>Jetpack XML solution</summary><br/>

XML TODO
</details>