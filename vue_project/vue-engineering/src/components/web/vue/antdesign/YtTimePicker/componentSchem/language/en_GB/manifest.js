export default {
  template: `
    <a-time-picker
      class="webVueAntYtTimePicker"
      :getPopupContainer="(trigger) => {
        return trigger
      }"
      :placeholder="_$placeholder$_"
      :format="_$format$_"
      :use12Hours="_$use12Hours$_"
      :disabled="_$disabled$_"
      :style="{
        width: '100%',
        height:'100%',
        opacity:_$opacity$_,
        color: _$text.fontStyle.color$_,
        fontFamily: _$text.fontFamily$_,
        fontSize: _$text.fontSize$_,
        fontWeight: _$text.fontWeight$_,
        lineHeight: _$text.lineHeight$_,
        background: _$fill.background$_,
        borderTopLeftRadius: _$radius.borderTopLeftRadius$_,
        borderTopRightRadius: _$radius.borderTopRightRadius$_,
        borderBottomLeftRadius: _$radius.borderBottomLeftRadius$_,
        borderBottomRightRadius: _$radius.borderBottomRightRadius$_,
        borderTop: _$border.borderTop$_,
        borderRight: _$border.borderRight$_,
        borderBottom: _$border.borderBottom$_,
        borderLeft: _$border.borderLeft$_,
        boxShadow: _$shadow.boxShadow$_,
        letterSpacing: _$text.letterSpacing$_,
        verticalAlign: _$text.verticalAlign$_,
        textDecoration: _$text.textDecoration$_,
        fontStyle: _$text.fontStyle$_,
        textAlign: _$text.textAlign$_,
        textAlignLast: _$text.textAlign$_
      }"/>
  `,
  clazzType: 'YtTimePicker'
}