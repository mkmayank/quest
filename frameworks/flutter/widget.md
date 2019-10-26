[https://flutter.dev/docs/development/ui/widgets-intro](https://flutter.dev/docs/development/ui/widgets-intro)

##### widget
    * Flutter widgets takes inspiration from React.
    * UI is built out of widgets.
    * Widgets describe what their view should look like given their current configuration and state.
    * When a widget’s state changes, the widget rebuilds its description, which the framework diffs against the previous description in order to determine the minimal changes needed in the underlying render tree to transition from one state to the next.

---

##### runApp()

    * The minimal Flutter app simply calls the runApp() function with a widget.
    * The runApp() function takes the given Widget and makes it the root of the widget tree.
    * The framework forces the root widget to cover the screen.

    * To create new Widgets, simple create subclasses of either StatelessWidget or StatefulWidget, depending on whether your widget manages any state.
    * A widget’s main job is to implement a build() function, which describes the widget in terms of other, lower-level widgets.
    * The framework builds those widgets in turn until the process bottoms out in widgets that represent the underlying RenderObject, which computes and describes the geometry of the widget.

    * Calling runApp again will detach the previous root widget from the screen and attach the given widget in its place.

---

#####   setState()
#####   State