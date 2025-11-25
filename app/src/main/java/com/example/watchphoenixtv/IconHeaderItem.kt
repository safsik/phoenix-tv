import androidx.leanback.widget.HeaderItem
import androidx.annotation.DrawableRes

/**
 * A custom HeaderItem that holds an optional icon resource ID.
 */
public class IconHeaderItem(
    id: Long,
    name: String,
    @param:DrawableRes val iconResId: Int = NO_ICON
) : HeaderItem(id, name) {

    // Secondary constructor if you don't need a specific ID
    constructor(name: String, @DrawableRes iconResId: Int = NO_ICON) :
            this(id = 1000, name, iconResId)

    companion object {
        const val NO_ICON = 0
    }
}