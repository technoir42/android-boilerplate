#!/usr/bin/env bash
set -e

placeholder_app_id="com.sch.android.boilerplate"
placeholder_project_name="Android Boilerplate"
placeholder_class_name="BoilerplateApplication"

source_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
project_dir=$(pwd)
archive_path=$(mktemp /tmp/XXXXXX)

if [[ "$source_dir" = "$project_dir" ]]; then
    echo "Run clone.sh from a project directory"
    exit 1
fi

while read -p "Project name: " project_name && [[ -z "$project_name" ]]; do :; done
while read -p "Application ID: " app_id && [[ -z "$app_id" ]]; do :; done

# Clone project
cd "$source_dir"
git archive -o "$archive_path" --format=zip HEAD

cd "$project_dir"
unzip -q "$archive_path" -x "clone.sh"
rm -f "$archive_path"

# Rename packages
find . -type f \( -name "*.kt" -or -name "*.xml" -or -name "*.gradle" \) -exec \
    sed -i "" "s/$placeholder_app_id/$app_id/g" "{}" \;

find . -type f -name "*.xml" -exec \
    sed -i "" "s/$placeholder_project_name/$project_name/g" "{}" \;

# Move files
src_package_dir=${placeholder_app_id//\.//}
dest_package_dir=${app_id//\.//}

for file_path in $(find . -type f -path "*/$src_package_dir/*"); do
    dest_file_path=${file_path//$src_package_dir/$dest_package_dir}
    mkdir -p "$(dirname "$dest_file_path")"
    mv "$file_path" "$dest_file_path"
done

find . -type d -empty -delete

# Rename Application class
dest_class_name="$(echo "$project_name" | sed "s/ //g")Application"

for file_path in $(find . -type f -name "*$placeholder_class_name*.kt"); do
    dest_file_path=${file_path//$placeholder_class_name/$dest_class_name}
    sed -i "" "s/$placeholder_class_name/$dest_class_name/g" "$file_path"
    mv "$file_path" "$dest_file_path"
done

find . -type f -name "*.xml" -exec \
    sed -i "" "s/$placeholder_class_name/$dest_class_name/g" "{}" \;

# Create README file
cat > README.md <<- EOM
${project_name}
$(printf "=%.0s" $(seq 1 ${#project_name}))
EOM

# Create Git repository
git init .
git add .
