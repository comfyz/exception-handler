package xyz.comfyz.rest.exceptions.handler;


public enum HttpStatus {

    InvalidFieldException(0, "");

    private final int value;

    private final String reasonPhrase;


    HttpStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }


    /**
     * Return the integer value of this status code.
     */
    public int value() {
        return this.value;
    }

    /**
     * Return the reason phrase of this status code.
     */
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    /**
     * Whether this status code is in the HTTP series
     * {@link org.springframework.http.HttpStatus.Series#INFORMATIONAL}.
     * This is a shortcut for checking the value of {@link #series()}.
     */
    public boolean is1xxInformational() {
        return org.springframework.http.HttpStatus.Series.INFORMATIONAL.equals(series());
    }

    /**
     * Whether this status code is in the HTTP series
     * {@link org.springframework.http.HttpStatus.Series#SUCCESSFUL}.
     * This is a shortcut for checking the value of {@link #series()}.
     */
    public boolean is2xxSuccessful() {
        return org.springframework.http.HttpStatus.Series.SUCCESSFUL.equals(series());
    }

    /**
     * Whether this status code is in the HTTP series
     * {@link org.springframework.http.HttpStatus.Series#REDIRECTION}.
     * This is a shortcut for checking the value of {@link #series()}.
     */
    public boolean is3xxRedirection() {
        return org.springframework.http.HttpStatus.Series.REDIRECTION.equals(series());
    }


    /**
     * Whether this status code is in the HTTP series
     * {@link org.springframework.http.HttpStatus.Series#CLIENT_ERROR}.
     * This is a shortcut for checking the value of {@link #series()}.
     */
    public boolean is4xxClientError() {
        return org.springframework.http.HttpStatus.Series.CLIENT_ERROR.equals(series());
    }

    /**
     * Whether this status code is in the HTTP series
     * {@link org.springframework.http.HttpStatus.Series#SERVER_ERROR}.
     * This is a shortcut for checking the value of {@link #series()}.
     */
    public boolean is5xxServerError() {
        return org.springframework.http.HttpStatus.Series.SERVER_ERROR.equals(series());
    }

    /**
     * Returns the HTTP status series of this status code.
     *
     * @see org.springframework.http.HttpStatus.Series
     */
    public org.springframework.http.HttpStatus.Series series() {
        int value = Integer.valueOf(String.valueOf(this.value).substring(0,1))*100;
        return org.springframework.http.HttpStatus.Series.valueOf(value);
    }

    /**
     * Return a string representation of this status code.
     */
    @Override
    public String toString() {
        return Integer.toString(this.value);
    }


    /**
     * Return the enum constant of this type with the specified numeric value.
     *
     * @param statusCode the numeric value of the enum to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
     */
    public static HttpStatus valueOf(int statusCode) {
        for (HttpStatus status : values()) {
            if (status.value == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
    }

}
