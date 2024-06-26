//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `smarthouse.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHouseIce;

public enum LightBulbMode implements java.io.Serializable
{
    NORMAL(0),
    BLINK(1),
    BREATH(2),
    STROBE(3),
    COLORCYCLE(4);

    public int value()
    {
        return _value;
    }

    public static LightBulbMode valueOf(int v)
    {
        switch(v)
        {
        case 0:
            return NORMAL;
        case 1:
            return BLINK;
        case 2:
            return BREATH;
        case 3:
            return STROBE;
        case 4:
            return COLORCYCLE;
        }
        return null;
    }

    private LightBulbMode(int v)
    {
        _value = v;
    }

    public void ice_write(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeEnum(_value, 4);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, LightBulbMode v)
    {
        if(v == null)
        {
            ostr.writeEnum(SmartHouseIce.LightBulbMode.NORMAL.value(), 4);
        }
        else
        {
            ostr.writeEnum(v.value(), 4);
        }
    }

    public static LightBulbMode ice_read(com.zeroc.Ice.InputStream istr)
    {
        int v = istr.readEnum(4);
        return validate(v);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<LightBulbMode> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, LightBulbMode v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            ice_write(ostr, v);
        }
    }

    public static java.util.Optional<LightBulbMode> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            return java.util.Optional.of(ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static LightBulbMode validate(int v)
    {
        final LightBulbMode e = valueOf(v);
        if(e == null)
        {
            throw new com.zeroc.Ice.MarshalException("enumerator value " + v + " is out of range");
        }
        return e;
    }

    private final int _value;
}
