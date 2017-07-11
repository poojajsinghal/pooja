

# Script used to read Property File
FILE_NAME=$2

# Key in Property File
key1="x"

# Variable to hold the Property Value
prop_value=""

function getProperty()
{
        prop_key=$1
        prop_value="$(cat ${FILE_NAME} | grep ${prop_key} | cut -d'=' -f2)"
}

while IFS='' read -r line || [[ -n "$line" ]]; do
    key1="$(echo $line | grep -o '\[[^]]*\]\]')"
    getProperty ${key1}
    echo "Key = ${key1} ; Value = " ${prop_value}
done < "$1"

