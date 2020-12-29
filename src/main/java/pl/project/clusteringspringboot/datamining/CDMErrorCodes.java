package pl.project.clusteringspringboot.datamining;

public interface CDMErrorCodes {

    int GENERIC_ERROR = 1000;
    int CONNECTION_FAILURE = 1001;
    int CONNECTION_OPEN_FAILED = 1002;
    int CONNECTION_CLOSE_FAILED = 1003;
    int ENTRY_NOT_FOUND = 1004;
    int RESERVED_1005 = 1005;
    int DUPLICATE_ENTRY = 1006;
    int INVALID_URI = 1007;
    int INACCESSIBLE_URI = 1008;
    int INCOMPATIBLE_ARGUMENT_SPECIFICATION = 1009;
    int INCOMPATIBLE_SPECIFICATION = 1010;
    int INVALID_USAGE = 1011;
    int INVALID_SETTINGS = 1012;
    int OBJECT_NOT_FOUND = 1013;
    int OBJECT_EXISTS = 1014;
    int TASK_EXECUTING = 1015;
    int TASK_NOT_EXECUTING = 1016;
    int TASK_FAILED = 1017;
    int VENDOR_SPECIFIC_ERROR_CODE_BEGIN = 2000;
    int VENDOR_SPECIFIC_ERROR_CODE_END = 9999;
    int RUNTIME_GENERIC_ERROR = 1500;
    int UNSUPPORTED_FEATURE = 1501;
    int NULL_ARGUMENT = 1502;
    int ARRAY_MISMATCH = 1503;
    int INVALID_ARGUMENT = 1504;
    int INVALID_STRING_ARGUMENT = 1505;
    int STRING_TOO_LONG = 1506;
    int INVALID_CLASS_NAME = 1507;
    int INVALID_DATA_TYPE = 1508;
    int ARRAY_SIZE_EXCEEDED = 1509;
    int INVALID_OBJECT_TYPE = 1510;
    int INVALID_OBJECT = 1511;
}
