Constraints allow you to restrict your mappings to only work in some situations.

### Screen is on/off (ROOT)
Only allow the key map to be triggered when the screen is on/off. This is only supported by buttons which can be detected when the screen is off.  Here is a [list](keymaps.md#detect-trigger-when-screen-is-off-root-200)  of these buttons.

### App in/not foreground
Your mapping will only work if your app of choice is the actively selected window, i.e. on screen and being interacted with. 'App not in foreground' will likewise restrict your map to working only if your app of choice isn't in focus.

### Specific app playing media (2.2.0+)
Your mapping will only work if your app of choice is playing media.

### Bluetooth device is connected/disconnected
Your mapping will only work if a specific bluetooth device is connected/disconnected.

### Screen is on/off (ROOT)

!!! info "Only for key maps"
If you have [root permission](#), you can restrict your mappings to only work when the screen is on or off. 

### Orientation (2.2.0+)
This will restrict your gesture map to work only when the device is set to a specific screen orientation.