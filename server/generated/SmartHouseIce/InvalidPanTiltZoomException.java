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

public class InvalidPanTiltZoomException extends com.zeroc.Ice.UserException
{
    public InvalidPanTiltZoomException()
    {
    }

    public InvalidPanTiltZoomException(Throwable cause)
    {
        super(cause);
    }

    public String ice_id()
    {
        return "::SmartHouseIce::InvalidPanTiltZoomException";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::SmartHouseIce::InvalidPanTiltZoomException", -1, true);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
    }

    /** @hidden */
    public static final long serialVersionUID = 6108475008300292318L;
}
