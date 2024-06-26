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

public interface PTZSurveillanceCamera extends SurveillanceCamera
{
    PanTiltZoom getPanTiltZoom(com.zeroc.Ice.Current current);

    void setPanTiltZoom(int panAngle, int tiltAngle, float zoom, com.zeroc.Ice.Current current)
        throws InvalidPanTiltZoomException;

    void resetPanTiltZoom(com.zeroc.Ice.Current current);

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::SmartHouseIce::Device",
        "::SmartHouseIce::PTZSurveillanceCamera",
        "::SmartHouseIce::SurveillanceCamera"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::SmartHouseIce::PTZSurveillanceCamera";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getPanTiltZoom(PTZSurveillanceCamera obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        inS.readEmptyParams();
        PanTiltZoom ret = obj.getPanTiltZoom(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        PanTiltZoom.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setPanTiltZoom(PTZSurveillanceCamera obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        int iceP_panAngle;
        int iceP_tiltAngle;
        float iceP_zoom;
        iceP_panAngle = istr.readInt();
        iceP_tiltAngle = istr.readInt();
        iceP_zoom = istr.readFloat();
        inS.endReadParams();
        obj.setPanTiltZoom(iceP_panAngle, iceP_tiltAngle, iceP_zoom, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_resetPanTiltZoom(PTZSurveillanceCamera obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        obj.resetPanTiltZoom(current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "getPanTiltZoom",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "isRecording",
        "isTurnedOn",
        "resetPanTiltZoom",
        "setPanTiltZoom",
        "startRecording",
        "stopRecording",
        "takePicture",
        "turnOff",
        "turnOn"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return _iceD_getPanTiltZoom(this, in, current);
            }
            case 1:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 2:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 3:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 4:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 5:
            {
                return SurveillanceCamera._iceD_isRecording(this, in, current);
            }
            case 6:
            {
                return Device._iceD_isTurnedOn(this, in, current);
            }
            case 7:
            {
                return _iceD_resetPanTiltZoom(this, in, current);
            }
            case 8:
            {
                return _iceD_setPanTiltZoom(this, in, current);
            }
            case 9:
            {
                return SurveillanceCamera._iceD_startRecording(this, in, current);
            }
            case 10:
            {
                return SurveillanceCamera._iceD_stopRecording(this, in, current);
            }
            case 11:
            {
                return SurveillanceCamera._iceD_takePicture(this, in, current);
            }
            case 12:
            {
                return Device._iceD_turnOff(this, in, current);
            }
            case 13:
            {
                return Device._iceD_turnOn(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
